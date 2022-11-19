package inf353;

import java.io.*;
import java.lang.Math;

public class Recherche {

    public MatriceIndexNaive M ; // la matrice d'index qui sera lit , elle sera remplie
    public BufferedReader br = null; // sera utilisé pour lire une line d'un fichier txt
    public String contentLine = ""; // utilisé avec le bufferReader pour lire une ligne
    public int nbDoc=0;
    public int nbTerm=0;

    public DictionnaireNaif requeteDict;
    public DictionnaireNaif lecteurDicoTerm ;
    public DictionnaireNaif lecteurDicoDocs ;
    public float[] tabPertinence;
    // le tableau qui contient les chars spéciaux
    public static char[] charAccepte = new char[16];


    public Recherche(int N) throws IOException {
        Indexation i = new Indexation("D:\\University\\sample","matriceAdjacence","docsQuoi","Termz");
        lectureMatrice("matriceAdjacence");
        lecteurRequete();
        lecteurDictionnaire("termes",'T');
        lecteurDictionnaire("documents",'D');
        calcDocPlusPertienent(N);
    }

    public void lectureMatrice(String matrixName) throws IOException {
        //---------------------------Lecture du nombre de colonnes et de lignes ---------------------
        // initialisé un buffer reader qui va faire office de lecteur de ligne
        br = new BufferedReader(new FileReader("./src/main/resources/"+matrixName+".txt"));
        // lire la première ligne et la save dans une string
        String NumSousFormeDeString = br.readLine();
        // si c'est pas la fin du fichier ( il est vide )
        if(NumSousFormeDeString != null)
            nbDoc   =Integer.parseInt(NumSousFormeDeString);// prendre le num qui est sous forme de String et le transformer en int , en gros "25" devient 25
        // lire la 2 ème ligne du fichier
        NumSousFormeDeString = br.readLine();
        // si le fichier contient cette deuxième ligne et ce n'est pas un fichier à une seul ligne
        if(NumSousFormeDeString != null)
            nbTerm =Integer.parseInt(NumSousFormeDeString);// on fait de même avec nb ligne

        //-------------------------------Lecture de la matrice et création de notre matrice --------
        // si il y a vraiment une matrice dans le fichier sinon on fait rien
        if(nbTerm>0 && nbDoc>0) {
            M = new MatriceIndexNaive(nbDoc, nbTerm);// initialisation d'une matrice de 0
            int i = 0 ; // pour parcourir les lignes
            int j = 0 ; // pour parcourir les colonnes
            // on ignore les 2 première lignes car elle contiennent nbrDoc et nbTerms respectivement
            contentLine = br.readLine();
            // on lit la première case de la matrice [0,0]
            while (i!=nbDoc) {
                j=0;
                while(j!=nbTerm){
                    M.affecte(i,j,Integer.parseInt(contentLine));
                    j++;
                    contentLine = br.readLine();
                }
                i++;
            }
        }
    }

    public void lecteurRequete() throws IOException {
        File f = new File("./src/main/resources");
        String motLus="";
        int lus= 0;
        br = new BufferedReader(new FileReader(f+"/requete.txt"));
        requeteDict = new DictionnaireNaif(1000);
        lus = br.read();
        while(lus!=-1){
            if(charAccepte((char)lus)){
                motLus+=(char)lus;
            }else{
                if(motLus.length()!=0)
                requeteDict.ajouterMot(motLus);
                motLus="";
            }
            lus = br.read();
        }
        if(motLus.length()!=0)
            requeteDict.ajouterMot(motLus);
    }
    public static boolean charAccepte(int c) {
        return ( c>47 && c<58 )||( c>64 && c<91 ) || ( c>96 && c<123 ) || (c>191 && c<256);
    }
    /*
    public String lireFichier(String fileName) throws IOException{
        String fichierSousFormeDeString ="";
        File f = new File("./src/main/resources");
        br = new BufferedReader(new FileReader(f+"/"+fileName));
        contentLine = br.readLine();
        while(contentLine!=null){
            fichierSousFormeDeString+=" "+contentLine;
            contentLine = br.readLine();
        }
        return fichierSousFormeDeString;
    }

     */
    public void lecteurDictionnaire(String path,char c) throws IOException{

        int i = 0; // Compteur
        br = new BufferedReader(new FileReader("./src/main/resources/"+path+".txt"));
        contentLine = br.readLine(); // Première ligne
        nbTerm = Integer.parseInt(contentLine); // Lecture de la première ligne pour récupérer le nombre de termes.
        nbDoc = Integer.parseInt(contentLine);
        if(c=='T') {
            lecteurDicoTerm = new DictionnaireNaif(nbTerm); // Instanciation du dictionnaire.
            if(nbTerm > 0 ) {
                contentLine = br.readLine(); // Deuxième Ligne pour commencer à ajouter les termes.
                //System.out.println("Duexieme Ligne : "+contentLine);
                while (i != nbTerm) {
                    lecteurDicoTerm.ajouterMot(contentLine);
                    i++;
                    contentLine = br.readLine();
                }
            }
        }else{
            if(c=='D') {
                lecteurDicoDocs = new DictionnaireNaif(nbDoc);
                if(nbDoc > 0 ) {
                    contentLine = br.readLine(); // Deuxième Ligne pour commencer à ajouter les termes.
                    //System.out.println("Duexieme Ligne : "+contentLine);
                    while (i != nbDoc) {
                        lecteurDicoDocs.ajouterMot(contentLine);
                        i++;
                        contentLine = br.readLine();
                    }
                }
            }else{
                System.out.println("char entrée non pris en compte , veuillez mettre soit D ou bien T");
            }
        }



    }

    public void calcDocPlusPertienent(int N){
        int i = 0 ;
        float somme = 0;
        // la pertinence de chaque documents
        tabPertinence = new float[nbDoc];
        while(i!=lecteurDicoDocs.nbMots()){
            int j=0;
            while(j!=requeteDict.nbMots()) {
                if (lecteurDicoTerm.contient(requeteDict.motIndice(i))) {
                    somme = (float) (somme + 1 + Math.log(M.val(i, lecteurDicoTerm.indiceMot(requeteDict.motIndice(i)))));
                }
                j++;
            }
            tabPertinence[i]=somme;
            somme = 0;
            i++;
        }
        trieDocPlusPert(N);
    }

    public void trieDocPlusPert(int N){
        int j = 0 ;
        int i = 0;
        int n = 0 ;
        float max = 0 ;
        while(j != N){
            max = tabPertinence[0];
            i = 1;
            while(i != tabPertinence.length){
                if(max<=tabPertinence[i]){
                    max = tabPertinence[i];
                }
                i++;
            }
            // n contient l'indice du Doc car le tableau des pert est : pertD1 , pertD2 ,....
            n = indiceMot(max);
            if (tabPertinence[n]==0  && j==0){
                System.out.println(" DESOLE NOUS NE POUVONS PAS VOUS AIDER VOTRE REQUETE N'APPARAIT DANS AUCUN DE NOS DOCUMENTS ") ;

            } else  {
                while (tabPertinence[n]>0 ){
                    System.out.println(lecteurDicoDocs.motIndice(n));
                    tabPertinence[n]=-1;
                }

            }
            j++;



        }

    }
    public int indiceMot(float x){
        int i = 0 ;
        while(i!=tabPertinence.length && x!=tabPertinence[i]){
            i++;
        }
        if(i!=tabPertinence.length){
            return i ;
        }else{
            return -1;
        }
    }
}

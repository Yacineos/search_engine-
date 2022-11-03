package inf353;

import java.io.*;


public class Recherche {

    public MatriceIndexNaive M ; // la matrice d'index qui sera lit , elle sera remplie
    public BufferedReader br = null; // sera utilisé pour lire une line d'un fichier txt
    public String contentLine = ""; // utilisé avec le bufferReader pour lire une ligne
    public int nbDoc=0;
    public int nbTerm=0;

    public DictionnaireNaif requeteDict;
    public DictionnaireNaif lecteurDico ;
    // le tableau qui contient les chars spéciaux
    public static char[] charAccepte = new char[16];


    public Recherche() throws IOException {

    }

    void lectureMatrice() throws IOException {
        //---------------------------Lecture du nombre de colonnes et de lignes ---------------------
        // initialisé un buffer reader qui va faire office de lecteur de ligne
        br = new BufferedReader(new FileReader("./src/main/resources/matriceIndex.txt"));
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
            br = new BufferedReader(new FileReader("./src/main/resources/matriceIndex.txt"));
            int i = 0 ; // pour parcourir les lignes
            int j = 0 ; // pour parcourir les colonnes
            // on ignore les 2 première lignes car elle contiennent nbrDoc et nbTerms respectivement
            contentLine = br.readLine();
            contentLine = br.readLine();
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
        String requeteLus = lireFichier("./src/main/resources/requete.txt");
        String motLus="";
        requeteDict = new DictionnaireNaif(1000);
        int i = 0;
        while(i!=requeteLus.length()){
            if( charAccepte(requeteLus.codePointAt(i))){
                motLus+=requeteLus.charAt(i);
            }else{
                if(motLus.length()!=0)
                requeteDict.ajouterMot(motLus);
                motLus="";
            }
            i++;
        }
        if(motLus.length()!=0)
            requeteDict.ajouterMot(motLus);
    }
    public static boolean charAccepte(int c) {
        return ( c>47 && c<58 )||( c>64 && c<91 ) || ( c>96 && c<123 ) || (c>191 && c<256);
    }
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
    public void lecteurDictionnaire() throws IOException{

        int i = 0; // Compteur
        br = new BufferedReader(new FileReader("./src/main/resources/termes.txt"));
        contentLine = br.readLine(); // Première ligne
        nbTerm = Integer.parseInt(contentLine); // Lecture de la première ligne pour récupérer le nombre de termes.
        lecteurDico = new DictionnaireNaif(nbTerm); // Instanciation du dictionnaire.

        //System.out.println("Nb termes : "+nbTerm);
        if(nbTerm > 0 ) {
            contentLine = br.readLine(); // Deuxième Ligne pour commencer à ajouter les termes.
            //System.out.println("Duexieme Ligne : "+contentLine);
            while (i != nbTerm) {
                lecteurDico.ajouterMot(contentLine);
                i++;
                contentLine = br.readLine();
            }
        }

    }
}

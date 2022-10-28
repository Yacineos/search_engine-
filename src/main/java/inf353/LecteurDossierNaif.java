package inf353;
import java.io.File ;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Classe LecteurDossierNaif.
 * Elle donne accès à un texte contenu dans tous les fichiers
 * d'un dossier et de ses sous dossiers et des sous dossiers
 * de ces sous dossiers et des sous dossiers de ces sous dossier
 * de sous dossiers... mot par mot.
 */

public class LecteurDossierNaif {

    public String texte = "";
    public File f;
    public String eCourant;
    public boolean fds = false;
    public int i = 0;
    public DictionnaireNaif dicD;
    public DictionnaireNaif dicT;
    public int nbDTotal=0;
    public int nbMTotal=0;





    //constructeur qui prend en paramètre le chemin du dossier
    public LecteurDossierNaif(String pathD) throws java.io.IOException {
        f = new File(pathD);
        tousLesMots(f); //modifie l'attribut texte, qui contiendra tout les mots.
        nbDocsTotal(f); //modifie l'attribut nbDTotal
        nbMotsTotal(); //modifie l'attribut nbDTotal

        //création des deux dictionnaires
        dicD = new DictionnaireNaif(nbDTotal); 
        dicT = new DictionnaireNaif(nbMTotal);
    }


    /**
     * Initialisation du parcours.
     */
    public void demarrer() {
        while( i != texte.length()  && !charAccepte(texte.charAt(i))){
            i++;
        }
        avancer();
    }

    /**
     * Passage à l'élément suivant
     */ 
    public void avancer() {
        eCourant = "";
        if (i == texte.length() ){
            fds = true;
        }
        while(i != texte.length() && charAccepte(texte.charAt(i))){
            eCourant = eCourant + texte.charAt(i);
            i++;
        }
        while(i != texte.length() && !charAccepte(texte.charAt(i))){
            i++;
        }
    }

    /**
     * vrai ssi la séquence est épuisée
     * @return
     */
    public boolean finDeSequence(){
     return fds;
    }

    /**
     * renvoie l'élément courant
     * @return
     */
    public String elementCourant(){
        return eCourant;
    }

    public static boolean charAccepte(char c) {
        return ( c>47 && c<58)||( c>64 && c<91 ) || ( c>96 && c<123 ) || (c>191 && c<256);
    }


    /*
     * Cette méthode modifie l'attribut nbDTotal
     */
    private void nbDocsTotal(final File folder) throws java.io.IOException{
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                nbDocsTotal(fileEntry);
            }else{
                nbDTotal++;
            }
            
        }
    }

    /*
     * Cette méthode modifie l'attribut nbMTotal
     */
    public void nbMotsTotal(){
        int j = 0;
        while(j != texte.length()){
            while(j != texte.length() && !charAccepte(texte.charAt(j))){
                j++;
            }
            if (j != texte.length()){
                nbMTotal++;
                while(j != texte.length() && charAccepte(texte.charAt(j))){
                    j++;
                }
            }
        }
    }
    
    /*
     * Cette méthode modifie l'attribut texte en stockant tous les mots dedans
     */
    private void tousLesMots(final File folder) throws java.io.IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                tousLesMots(fileEntry);
            } else {
                if(fileEntry.getName()!=".DS_Store"){
                    BufferedReader br = new BufferedReader(new FileReader(fileEntry));
                    String ligne;
                    //on stock tout les mots de tous les fichiers dans texte
                    while ((ligne = br.readLine())!=null){
                        texte = texte + ligne + " ";
                    }
                }
            }
        }
    }

    /**
     * Cette méthode permet de remplir le tableau de l'attribut dicD
     * 
     */
    private void tousLesDocs(final File folder) throws java.io.IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                tousLesDocs(fileEntry);
            } else {
                if(!fileEntry.getName().equals(".DS_Store")){
                    dicD.ajouterMot(fileEntry.getName());
                }
            }
        }
    }

    public void sauverDocs(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //rempli le dictionnaire dicD de tous les noms de documents du dossier f
        tousLesDocs(f);

        //crée le fichier de nom "nomFichier.txt", s'il n'existe pas, où l'on va sauver le dictionnaire des documents
        File sauver = new File("./" + nomDeFichier + ".txt");
        int d =0;
        if (!sauver.exists()) {
            sauver.createNewFile();
            FileWriter fw = new FileWriter(sauver.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+dicD.nbMots());
            bw.newLine();
            while(d != dicD.nbMots()){
                bw.write(dicD.motIndice(d));
                bw.newLine();
                d++;
            }
            bw.close();
        }else{ 
            System.out.println("ce nom de fichier existe déjà");
        }
    }

    /**
     * Cette méthode permet de remplir le tableau de l'attribut dicT
     * 
     */
    private void tousLesTermes(){
        demarrer();
        while(!finDeSequence()){
            dicT.ajouterMot(elementCourant());
            avancer();
        }
    }

    public void sauverTermes(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //rempli le dictionnaire dicT de tous les termes du dossier f
        tousLesTermes();
        
        //crée le fichier de nom "nomFichier.txt", s'il n'existe pas, où l'on va sauver le dictionnaire des termes
        File sauver = new File("./" + nomDeFichier + ".txt");
        if (!sauver.exists()) {
            int t =0;
            sauver.createNewFile();
            FileWriter fw = new FileWriter(sauver.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+dicT.nbMots());
                bw.newLine();
            while(t != dicT.nbMots()){
                bw.write(dicT.motIndice(t));
                bw.newLine();
                t++;
            }
            bw.close();
        }else{ 
            System.out.println("ce nom de fichier existe déjà");
        }
    }

}

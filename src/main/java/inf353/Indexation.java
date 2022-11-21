package inf353;
import java.io.*;

/**
 * Classe Indexation qui parcours l'ensemble du corpus, crée la matrice index
 * + les dictionnaires de documents et de termes et les sauve sur le disque.
 */

public class Indexation{

    public DictionnaireNaif dicD;
    public DictionnaireNaif dicT;
    public MatriceIndexNaive m;

    public int nbDocTotal;
    public DictionnaireNaif dicDpath;

    public String pathParcours;
    public String pathSauvegarde;

    /* Constructeur de la classe qui prend en paramètre le chemin du dossier à parcourir et le chemin du dossier de sauvegarde.
     * Les noms des fichiers txt de sauvegarde seront par défaut "matriceIndex", "documents" et "termes".
     */
    public Indexation(String pathParcours, String pathSauvegarde) throws java.io.IOException{
        this.pathParcours = pathParcours;
        this.pathSauvegarde = pathSauvegarde;

        File dossier = new File(pathParcours);
        File disque = new File(pathSauvegarde);

        if((dossier.exists() && dossier.isDirectory())  && (disque.exists() && disque.isDirectory())){
            dicDpath = new DictionnaireNaif(nbDocsTotal(dossier));
            remplirDicDpath(dossier);

            //création des trois dictionnaires
            dicD = new DictionnaireNaif(nbDocsTotal(dossier));
            remplirDicD(dossier);
            dicT = new DictionnaireNaif(nbMotsTotal());
            remplirDicT();
            m = new MatriceIndexNaive(dicD.nbMots(),dicT.nbMots());
            remplirMatrice();

            //sauve les trois fichier dans le disque
            sauverMatrice("matriceIndex");
            sauverDocs("documents");
            sauverTermes("termes");

        }else{
            if(!dossier.exists()){
                System.out.println("Indexation: Le dossier à parcourir est introuvable.");
            }else{
                if(!dossier.isDirectory()){
                    System.out.println("Indexation: Le dossier à parcourir n'est pas un dossier.");
                }
            }
            if(!disque.exists()){
                System.out.println("Indexation: Le dossier de sauvegarde est introuvable.");
            }else{
                if(!disque.isDirectory()){
                    System.out.println("Indexation: Le dossier de sauvegarde n'est pas un dossier.");
                }
            }
        }

    }

    /* Constructeur de la classe qui prend en paramètre le chemin du dossier à parcourir, le chemin du dossier de sauvegarde,
     * le nom du fichier de sauvegarde de la matrice, le nom du fichier de sauvegarde du dictionnaire de documents et
     * le nom du fichier de sauvegarde du dictionnaire de termes.
     */
    public Indexation(String pathParcours, String pathSauvegarde, String nomDeMatrice, String nomDeDocs, String nomDeTermes) throws java.io.IOException{
        this.pathParcours = pathParcours;
        this.pathSauvegarde = pathSauvegarde;

        File dossier = new File(pathParcours);
        File disque = new File(pathSauvegarde);

        if((dossier.exists() && dossier.isDirectory())  && (disque.exists() && disque.isDirectory())){
            dicDpath = new DictionnaireNaif(nbDocsTotal(dossier));
            remplirDicDpath(dossier);

            //création des trois dictionnaires
            dicD = new DictionnaireNaif(nbDocsTotal(dossier));
            remplirDicD(dossier);
            dicT = new DictionnaireNaif(nbMotsTotal());
            remplirDicT();
            m = new MatriceIndexNaive(dicD.nbMots(),dicT.nbMots());
            remplirMatrice();

            //sauve les trois fichier dans le disque
            sauverMatrice(nomDeMatrice);
            sauverDocs(nomDeDocs);
            sauverTermes(nomDeTermes);

        }else{
            if(!dossier.exists()){
                System.out.println("Indexation: Le dossier à parcourir est introuvable.");
            }else{
                if(!dossier.isDirectory()){
                    System.out.println("Indexation: Le dossier à parcourir n'est pas un dossier.");
                }
            }
            if(!disque.exists()){
                System.out.println("Indexation: Le dossier de sauvegarde est introuvable.");
            }else{
                if(!disque.isDirectory()){
                    System.out.println("Indexation: Le dossier de sauvegarde n'est pas un dossier.");
                }
            }
        }
    }

    /*
     * Remplissage du dictionnaire des chemins des documents: dicDpath
     * Pour le constructeur LecteurDocumentNaif qui prend en paramètre le chemin d'un document.
     */
    private void remplirDicDpath(final File folder) throws java.io.IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                remplirDicDpath(fileEntry);
            } else {
                if(!fileEntry.getName().equals(".DS_Store")){
                    dicDpath.ajouterMot(fileEntry.getPath());
                }
            }
        }
    }

    /*
     * Remplissage du dictionnaire des noms des documents: dicD.
     */
    private void remplirDicD(final File folder) throws java.io.IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                remplirDicD(fileEntry);
            } else {
                if(!fileEntry.getName().equals(".DS_Store")){
                    dicD.ajouterMot(fileEntry.getName());
                }
            }
        }
    }

    
    /*
     * Remplissage du dictionnaire des termes: dicT.
     */
    private void remplirDicT() throws java.io.IOException{
        int i = 0;
        while (i!=dicD.nbMots()){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicDpath.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                dicT.ajouterMot(f.elementCourant());
                f.avancer();
            }
            i++;
        }
    }

    /*
     * Remplissage de la matrice m.
     */
    private void remplirMatrice() throws java.io.IOException{
        int i = 0;
        while (i!=dicD.nbMots()){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicDpath.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                m.incremente(i,dicT.indiceMot(f.elementCourant()));
                f.avancer();
            }
            i++;
        }
    }
    
    /*
     * sauvegarde du dictionnaire des documents dans le fichier "nomDeFicher.txt"
     * la 1ère ligne contient le nombre de documents puis chaque ligne contient un nom de document 
     */
    public void sauverDocs(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //crée le fichier de nom "nomFichier.txt", où l'on va sauver le dictionnaire des documents
        File sauver = new File(pathSauvegarde + "/" + nomDeFichier + ".txt");
        sauver.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(sauver.getAbsoluteFile()));
        bw.write(""+dicD.nbMots());

        int d =0;
        while(d != dicD.nbMots()){
            bw.newLine();
            bw.write(dicD.motIndice(d));
            d++;
        }
        bw.close();
    }

    /*
     * sauvegarde du dictionnaire des termes dans le fichier "nomDeFicher.txt"
     * la 1ère ligne contient le nombre de termes puis chaque ligne contient un terme
     */
    public void sauverTermes(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //crée le fichier de nom "nomFichier.txt", où l'on va sauver le dictionnaire des termes
        File sauver = new File(pathSauvegarde + "/" + nomDeFichier + ".txt");
        sauver.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(sauver.getAbsoluteFile()));
        bw.write(""+dicT.nbMots());

        int t =0;
        while(t != dicT.nbMots()){
            bw.newLine();
            bw.write(dicT.motIndice(t));
            t++;
        }
        bw.close();
    }

    /*
     * sauvegarde de la matrice index dans le fichier "nomDeFicher.txt"
     * la 1ère ligne contient le nombre de documents, la 2ème ligne contient le nombre de termes
     * puis chaque ligne contient une valeur d'ocurrence d'un terme j dans un document i
     */
    public void sauverMatrice(String nomDeFichier) throws java.io.IOException, FileNotFoundException {
        File file = new File(pathSauvegarde + "/" + nomDeFichier + ".txt");
        file.createNewFile();
        BufferedWriter fw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            
        fw.write(""+m.ndoc);
        fw.newLine();
        fw.write(""+ m.nterm);
        fw.newLine();

        int i = 0 ;
        while(i != m.ndoc){
            int j = 0;
            while(j != m.nterm){
                fw.write(""+m.val(i,j));
                fw.newLine();  
                j++;
            }
            i++;
        }
        fw.close();
    }


    /*
     * Cette méthode renvoie le nombre de documents
     * en modifiant l'attribut nbDocTotal
     */
    private int nbDocsTotal(final File folder) throws java.io.IOException{
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                nbDocsTotal(fileEntry);
            }else{
                if(!fileEntry.getName().equals(".DS_Store")){
                    nbDocTotal++;
                }
            }
        }
        return nbDocTotal;
    }

    /*
     * Cette méthode renvoie le nombre de mots total
     */
    private int nbMotsTotal() throws java.io.IOException{
        int i =0;
        int nb =0;
        while(i != dicDpath.nbMots()){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicDpath.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                nb++;
                f.avancer();
            }
            i++;
       }
       return nb;
    }

    /* Main de la classe, qui prend soit deux paramètres: le chemin du dossier à parcourir et le chemin du dossier de sauvegarde
     * soit cinqs paramètres: les deux chemins + les noms des fichiers. (dans cette ordre: matrice index, dictionnaire documents, dictionnaire termes)
     */
    public static void main(String[] args) throws java.io.IOException{
        if(args.length == 2 ){
            new Indexation(args[0], args[1]);
        }else{
            new Indexation(args[0], args[1], args[2], args[3], args[4]);
        }
    }
}
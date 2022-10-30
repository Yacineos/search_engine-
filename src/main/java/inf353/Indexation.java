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

    public Indexation(String path, String nomDeMatrice, String nomDeDocs, String nomDeTermes) throws java.io.IOException {
        File dossier = new File(path);

        dicD = new DictionnaireNaif(nbDocsTotal(dossier));
        remplirDicD(dossier);

        dicT = new DictionnaireNaif(nbMotsTotal());
        remplirDicT();

        m = new MatriceIndexNaive(dicD.nbMots(),dicT.nbMots());
        remplirMatrice();

        //sauve les trois fichier dans le disque;
        sauverDocs(nomDeDocs);
        sauverTermes(nomDeTermes);
        m.sauver(nomDeMatrice);
    }

    /*
     * Remplissage du dictionnaire dicD avec les chemins des documents et non les noms, car
     * la classe LecteurDoumentNaif prend en paramètre le chemin absolument du document.
     */
    private void remplirDicD(final File folder) throws java.io.IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                remplirDicD(fileEntry);
            } else {
                if(!fileEntry.getName().equals(".DS_Store")){
                    dicD.ajouterMot(fileEntry.getPath());
                }
            }
        }
    }

    private void remplirDicT() throws java.io.IOException{
        int i =0;
        while (i!=dicD.nbMots()){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicD.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                dicT.ajouterMot(f.elementCourant());
                f.avancer();
            }
            i++;
        }
    }

    private void remplirMatrice() throws java.io.IOException{
       int i =0;
        while (i != m.ndoc){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicD.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                int j = 0;
                while(j != m.nterm){
                   if (dicD.memeMots(f.elementCourant(),dicT.motIndice(j)) ){
                        m.incremente(i,j);
                    }
                    j++;
                }
                f.avancer();
            }
            i++;
        }
    }


    public void sauverDocs(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //crée le fichier de nom "nomFichier.txt", s'il n'existe pas, où l'on va sauver le dictionnaire des documents
        File sauver = new File("../resources/" + nomDeFichier + ".txt");
        int d =0;
        if (!sauver.exists()) {
            sauver.createNewFile();
            FileWriter fw = new FileWriter(sauver.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+dicD.nbMots());
            while(d != dicD.nbMots()){
                bw.newLine();
                bw.write(dicD.motIndice(d));
                d++;
            }
            bw.close();
        }else{ 
            System.out.println("ce nom de fichier existe déjà");
        }
    }

    public void sauverTermes(String nomDeFichier) throws java.io.IOException, FileNotFoundException{
        //crée le fichier de nom "nomFichier.txt", s'il n'existe pas, où l'on va sauver le dictionnaire des termes
        File sauver = new File("../resources/" + nomDeFichier + ".txt");
        if (!sauver.exists()) {
            int t =0;
            sauver.createNewFile();
            FileWriter fw = new FileWriter(sauver.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+dicT.nbMots());
            while(t != dicT.nbMots()){
                bw.newLine();
                bw.write(dicT.motIndice(t));
                t++;
            }
            bw.close();
        }else{ 
            System.out.println("ce nom de fichier existe déjà");
        }
    }


    /*
     * Cette méthode modifie l'attribut nbDTotal
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
     * Cette méthode modifie l'attribut nbMTotal
     */
    private int nbMotsTotal() throws java.io.IOException{
        int i =0;
        int nb =0;
        while(i != dicD.nbMots()){
            LecteurDocumentNaif f = new LecteurDocumentNaif(dicD.motIndice(i));
            f.demarrer();
            while(!f.finDeSequence()){
                nb++;
                f.avancer();
            }
            i++;
       }
       return nb;
    }
}
package inf353;
import java.io.*; 

public class MainLecteur{
    public static void main(String[] args) throws java.io.IOException{
        
        //LecteurDossierNaif l = new LecteurDossierNaif("C:/Users/Angeline/sample");
         //MatriceIndexNaive m = new MatriceIndexNaive(17,1784);
         //m.sauver("matrice");
        Indexation index = new Indexation("C:/Users/Angeline/test", "matriceT", "documentsT", "termesT");
        //l.sauverDocs("documents");
        //l.sauverTermes("termes");

        //System.out.println();    
    }
}

// /home/aliang/ubuntu/angeli/sample
// "C:/Users/Angeline/sample"
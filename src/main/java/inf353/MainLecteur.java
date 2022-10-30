package inf353;
import java.io.*; 

public class MainLecteur{
    public static void main(String[] args) throws java.io.IOException{
        
        LecteurDossierNaif l = new LecteurDossierNaif("C:/Users/Angeline/sample");
        l.sauverDocs("documents");
        l.sauverTermes("termes");
        //System.out.println(l.elementCourant());    
    }
}

// /home/aliang/ubuntu/angeli/sample
// "C:/Users/Angeline/sample"
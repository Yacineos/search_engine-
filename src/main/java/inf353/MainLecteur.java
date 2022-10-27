package inf353;

public class MainLecteur{
    public static void main(String[] args) throws java.io.IOException{
        
        LecteurDossierNaif l = new LecteurDossierNaif("/home/aliang/ubuntu/angeli/sample");
        l.sauverDocs("documents");
        l.sauverTermes("termes");
        //System.out.println();    

    }
}

// /home/aliang/ubuntu/angeli/sample
package inf353;

public class MainLecteur{
    public static void main(String[] args) throws java.io.IOException{
        
        LecteurDossierNaif l = new LecteurDossierNaif("/home/aliang/ubuntu/angeli/sample");
        l.sauverDocs("/home/aliang/ubuntu/docs");
        l.sauverTermes("/home/aliang/ubuntu/termes");
        //System.out.println();    

    }
}

// /home/aliang/ubuntu/angeli/sample
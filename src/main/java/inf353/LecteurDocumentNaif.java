package inf353;
import java.io.*;
/**
 * Classe LecteurDocumentNaif qui implémente un accès séquenciel de modèle 1 d'élemnts de type String.
 * Elle donne accès à un texte contenu dans un fichier, mot par mot.
 */
public class LecteurDocumentNaif implements AccesSequentielModele1<String> {

    public String eCourant;
    public boolean fds = false;
    public int premier;
    public int i ;
    public BufferedReader br;
    public String path;
    
    public LecteurDocumentNaif(String path) throws java.io.IOException {
        this.path = path;
        System.setProperty( "file.encoding", "UTF-8" );

        //Lecture du fichier de chemin path
        br = new BufferedReader(new FileReader(new File(path)));

        //Stock du tout premier caractère dans l'int premier
        premier = br.read();

        //Si le fichier n'est pas vide
        if(premier != -1){ 
            br.mark(premier);
        }
    }
   
   
       /**
     * Initialisation du parcours.
     */
    public void demarrer() throws java.io.IOException{

        //si fin de séquence, il faut relire le fichier
        if(finDeSequence()){
            fds = false;
            System.setProperty( "file.encoding", "UTF-8" );
            br = new BufferedReader(new FileReader(new File(path)));
            premier = br.read();
            if(premier != -1){ 
                br.mark(premier);
            }
        }

        //Si le fichier n'est pas vide
        if(premier != -1){ 
            br.reset();
        }

        i = premier;
        while((i != -1 ) && !charAccepte(i)){
            i = br.read();
        }
        avancer();
    }

    /**
     * Passage à l'élément suivant
     */ 
    public void avancer() throws java.io.IOException {
        
        //si on est la fin du fichier
        if (i == -1){
            fds = true;
            br.close();
        }

        eCourant = "" ;
        while((i != -1 ) && charAccepte(i)){
            eCourant = eCourant + ((char)i);
            i =br.read();
        }
        while((i != -1 ) && !charAccepte(i)){
            i =br.read();
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

    public static boolean charAccepte(int c) {
        return ( c>47 && c<58) || ( c>64 && c<91 ) || ( c>96 && c<123 ) || (c>191 && c<256);
    }

    public void afficher() throws java.io.IOException {
        LecteurDocumentNaif l = new LecteurDocumentNaif(path);
        l.demarrer();
        while(!l.finDeSequence()){
            System.out.println(l.elementCourant());
            l.avancer();
        }
    }
}
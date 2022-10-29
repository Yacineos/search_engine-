package inf353;
import java.io.File ;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Classe LecteurDocumentNaif qui implémente un accès séquenciel de modèle 1 d'élemnts de type String.
 * Elle donne accès à un texte contenu dans un fichier, mot par mot.
 */
public class LecteurDocumentNaif implements AccesSequentielModele1<String> {

    public String texte = "";
    public String eCourant;
    public boolean fds = false;
    public int i = 0;

   public LecteurDocumentNaif(String path) throws java.io.IOException {
    File f = new File(path);
    BufferedReader br = new BufferedReader(new FileReader(f));

    String ligne;

    //on stock tout les mots dans texte
    while ((ligne = br.readLine())!=null){
        texte += ligne + " ";
    }

    System.out.println(texte);
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
}
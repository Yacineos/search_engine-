package inf353;

import java.io.IOException;

public class MainRecherche {
    public static void main(String[] args) throws IOException {
        Recherche r = new Recherche();
        r.lecteurDictionnaire();
        r.lecteurDico.afficher();
    }
}

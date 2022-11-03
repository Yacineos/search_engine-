package inf353;

public class Main{
    public static void main(String[] args) {
        DictionnaireNaif dict = new DictionnaireNaif(6);
        dict.ajouterMot("Angeline");
        dict.ajouterMot("Basma");
        dict.ajouterMot("Sara");
        dict.ajouterMot("Andy");
        dict.ajouterMot("Yacine");
        dict.ajouterMot("Messipsa");
        //dict.ajouterMot("Yacine");
        dict.ajouterMot("Symbaa");

        System.out.println("Les mots contenu dans le dictionnaire:");
        dict.afficher();
        //dict.vider();
        //dict.afficher();
        System.out.println("Nombres de mots:");
        System.out.println(dict.nbMots());

        System.out.println("Le mot d'indice 3");
        System.out.println(dict.motIndice(3));
        System.out.println("Le mot d'indice 5");
        System.out.println(dict.motIndice(5));
        System.out.println("Le mot d'indice 6");
        System.out.println(dict.motIndice(6));

        System.out.println("L'indice du mot Sara");
        System.out.println(dict.indiceMot("Sara"));

        System.out.println("L'indice du mot Sar");
        System.out.println(dict.indiceMot("Sar"));

        System.out.println("L'indice du mot Saraa");
        System.out.println(dict.indiceMot("Saraa"));

    }
}
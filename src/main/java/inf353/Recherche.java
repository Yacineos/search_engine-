package inf353;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Recherche {

    private MatriceIndexNaive M ; // la matrice d'index qui sera lit , elle sera remplie
    private BufferedReader br = null; // sera utilisé pour lire une line d'un fichier txt
    private int nbDoc=0;
    private int nbTerm=0;

    private String requeteLus=""; // sera utilisé pour lire le fichier qui contient la requête
    DictionnaireNaif requeteDict ;
    // le tableau qui contient les chars spéciaux
    public static char[] charAccepte = new char[16];


    public Recherche() throws IOException {
/*
        //---------------------------Lecture du nombre de colonnes et de lignes ---------------------
        // initialisé un buffer reader qui va faire office de lecteur de ligne
        br = new BufferedReader(new FileReader("B:\\myfile.txt"));
        // lire la première ligne et la save dans une string
        String NumSousFormeDeString = br.readLine();
        // si c'est pas la fin du fichier ( il est vide )
        if(NumSousFormeDeString != null)
        nbDoc   =Integer.parseInt(NumSousFormeDeString);// prendre le num qui est sous forme de String et le transformer en int , en gros "25" devient 25
        // lire la 2 ème ligne du fichier
        NumSousFormeDeString = br.readLine();
        // si le fichier contient cette deuxième ligne et ce n'est pas un fichier à une seul ligne
        if(NumSousFormeDeString != null)
        nbTerm =Integer.parseInt(br.readLine());// on fait de même avec nb ligne
   */
    }

    void lectureMatrice() throws IOException {
        // si il y a vraiment une matrice dans le fichier sinon on fait rien
        if(nbTerm>0 && nbDoc>0) {
            M = new MatriceIndexNaive(nbDoc, nbTerm);// initialisation d'une matrice de 0
            br = new BufferedReader(new FileReader("B:\\myfile.txt"));
            int i = 0 ; // pour parcourir les lignes
            int j = 0 ; // pour parcourir les colonnes
            // on ignore les 2 première lignes car elle contiennent nbrDoc et nbTerms respectivement
            String contentLine = br.readLine();
            contentLine = br.readLine();
            contentLine = br.readLine();
            // on lit la première case de la matrice [0,0]
            while (i!=nbDoc) {
                j=0;
                while(j!=nbTerm){
                    M.affecte(i,j,Integer.parseInt(contentLine));
                    j++;
                    contentLine = br.readLine();
                }
                i++;
            }
        }
    }

    public void lecteurRequete() throws IOException {
        /*
        requeteLus= Files.readString(Path.of(".\\text.txt"));
        String motLus="";
        requeteDict = new DictionnaireNaif(1000);
        int i = 0;
        while(i!=requeteLus.length()){
            if( charAccepte(requeteLus.codePointAt(i))){
                //   le char lu est un chiffre ( 0-9)                                  le char lu appartient à (A-Z)                                         le char lu appartient à ( a - z )                              le char lu est l'un des caractère spéciaux du tableau qu'on a crée
                motLus=motLus+requeteLus.charAt(i);
            }else{
                requeteDict.ajouterMot(motLus);
                motLus="";
            }

        }
    */
    }
    public static boolean charAccepte(int c) {
        return ( c>47 && c<58)||( c>64 && c<91 ) || ( c>96 && c<123 ) || (c>191 && c<256);
    }
}


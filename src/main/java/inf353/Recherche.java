package inf353;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Recherche {

    private MatriceIndexNaive M ; // la matrice d'index qui sera lit , elle sera remplie
    private BufferedReader br = null; // sera utilisé pour lire une line d'un fichier txt
    private int nbDoc=0;
    private int nbTerm=0;

    private String requeteLus=""; // sera utilisé pour lire le fichier qui contient la requête

    // le tableau qui contient les chars spéciaux
    private char[] charAccepte = new char[16];


    public Recherche() throws IOException {
        // ---------------------------remplissage du tableau des chars spéciaux -----------------------
        charAccepte[0]='à';
        charAccepte[1]='â';
        charAccepte[2]='ä';
        charAccepte[3]='é';
        charAccepte[4]='è';
        charAccepte[5]='ê';
        charAccepte[6]='ë';
        charAccepte[7]='î';
        charAccepte[8]='ï';
        charAccepte[9]='ô';
        charAccepte[10]='ö';
        charAccepte[11]='ù';
        charAccepte[12]='û';
        charAccepte[13]='ü';
        charAccepte[14]='ÿ';
        charAccepte[15]='ç';

        //---------------------------Lecture du nombre de colonnes et de lignes ---------------------
        // initialisé un buffer reader qui va faire office de lecteur de ligne
        br = new BufferedReader(new FileReader("B:\\myfile.txt"));
        // lire la première ligne et la save dans le une string
        String NumSousFormeDeString = br.readLine();
        // si c'est pas la fin du fichier ( il est vide )
        if(NumSousFormeDeString != null)
        nbDoc   =Integer.parseInt(NumSousFormeDeString);// prendre le num qui est sous forme de String et le transformer en int , en gros "25" devient 25
        // lire la 2 ème ligne du fichier
        NumSousFormeDeString = br.readLine();
        // si le fichier contient cette deuxième ligne et ce n'est pas un fichier à une seul ligne
        if(NumSousFormeDeString != null)
        nbTerm =Integer.parseInt(br.readLine());// on fait de même avec nb ligne
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
                    M.affecte(nbDoc,nbTerm)=Integer.parseInt(contentLine);
                    j++;
                    contentLine = br.readLine();
                }
                i++;
            }
        }
    }

    public void lecteurRequete() throws IOException {
        requeteLus= Files.readString(Path.of("D:\\test"));

    }
    public boolean contient(char c){
        int i = 0 ;

        while(i!=charAccepte.length){

            if(c == charAccepte[i])

                return true ;

            i++;

        }

        return false ;
    }
}

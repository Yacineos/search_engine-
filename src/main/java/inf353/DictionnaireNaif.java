package inf353;
public class DictionnaireNaif implements Dictionnaire{
    char[] d ;
    int i= 0;
    int n = 0;

    public DictionnaireNaif(int n){
        d = new char[n*4];
        this.n = n;
    }

    public void vider(){

    }
    public void ajouterMot(String m){

    }
    public int indiceMot(String m){
        int cpt = 0;


        while(d.length != i && compareMot(m)==false){
            if(cpt == n ){
                break;
            }
            cpt++;
        }
        if(cpt == n ){
            return -1;
        }
        if(d.length==i) {
            return -1;
        }else {
            return cpt;
        }
    }
    public boolean compareMot(String m ){
        int j = 0;
        // while pour vérifier qu'on est pas arrivé à la fin du tableau
        if(i != d.length){
            // while pour parcourir mot par mot et comparer avec m
            while(d[i]!=0 && j!=m.length()) {
                // si on tombe sur un caractère différent on retourne faux

                if (d[i] != m.charAt(j)){
                    return false;

                }else {
                    //sinon on incrément pour voir le prochain caractère
                    i++;
                    j++;
                }
            }
            if(j != m.length())
                return false ;


            // si on est arrivé à ce point la , du coup , le le mot actuel du dictionnaire est égal à mot
            if(m.length()==j && d[i]==0) {
                return true;
            }else {
                return false ;
            }
        }
        return false ;

    }

    public String motIndice(int i){
        return "";
    }
    public boolean contient(String m){
        return true;
    }
    public int nbMots(){
        return 0;
    }
    public boolean contientPrefixe(String p){
        return false;
    }
    public String plusLongPrefixeDe(String mot){
        return "";
    }
}

package inf353;
public class DictionnaireNaif implements Dictionnaire{
    char[] d ;
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
        int i = 0;
        int j = 0;
        int Pas = 4 ;
        
        while(d.length != i && m.length() > 0){
            if(d[i] != m.charAt(j) && j!=m.length() ){
                i = i + Pas;
            }else{
                i++;
                j++;
                Pas--;
                if(j == m.length() && d[i]==0){
                    return i - m.length();
                }
                

            }
            
        }
        return -1 ;

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

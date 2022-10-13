package inf353;
public class DictionnaireNaif implements Dictionnaire{
    char[] d ;
    int n = 0;

    public DictionnaireNaif(int n){
        d = new char[n*4];
        this.n = n;
    }

    public void vider(){
        int i = 0 ; 
        while(i!=d.length){
            d[i]= 0;
        }
        
    }
    public void ajouterMot(String m){
                int i=0 ;
            if(m.length()<4){
                 if(!contient(m)){
                   while(i< d.length  && d[i]!=0) {
                        i= i+4 ;  
                          }
                    if(i< d.length ) {
                       d[n]=m.charAt(i) ; 
                        i++;
                        n++;  
                       
                     }

                }
                     
            }
             

            
         }
        
     
                // d.add(m);
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
    //andy fais ça
    public String motIndice(int i){
        return "";
    }
    public boolean contient(String m){
        return (indiceMot(m) != -1);
    }
    public int nbMots(){
        int nb = 0;
        int pas = 0;
        while (pas != d.length){
            if (d[pas]!=0){
                nb++;
            }
            pas=pas+40;
        }
        return nb;
    }
    public boolean contientPrefixe(String p){
        return false;
    }
    public String plusLongPrefixeDe(String mot){
        return "";
    }
}

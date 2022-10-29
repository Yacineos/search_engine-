package inf353;
public class DictionnaireNaif implements Dictionnaire{
    char[] d ;
    int n = 0;

    public DictionnaireNaif(int n){
        d = new char[n*40];
        this.n = n;
    }

    public void vider(){
        int i = 0 ; 
        while(i!=d.length){
            d[i]= 0;
        }
        
    }

    public void ajouterMot(String m){
        int i = 0;
        int pas = 40;
        if(m.length() <40){
            if(!contient(m)){
                while(i!= d.length){
                    if(d[i] != 0){
                        i=i+pas;
                    }else{
                        int j =0;
                        while(j!=m.length()){
                            d[i] = m.charAt(j);
                            i++;
                            j++;
                        }
                        i=d.length;
                    }
                }
            }
        }
    }

   /* public void ajouterMot(String m){
                int i=0 ;
            if(m.length()<40){
                 if(!contient(m)){
                   while(i< d.length  && d[i]!=0) {
                        i= i+40 ;  
                          }
                    if(i< d.length ) {
                       d[n]=m.charAt(i) ; 
                        i++;
                        n++;  
                       
                     }

                }
                     
            }
             

            
         }*/
        
     
         public int indiceMot(String m){
            int i = 0;
            int pas = 40;
            String s ="";
            int indice = 0;
            
            while(i!=d.length){
                 if(d[i] == 0){
                    i = i+pas;
                    indice++;
                 }else{
                    while(d[i]!=0){
                        s = s + d[i];
                        i++;
                        pas--;
                    }
                    if(memeMots(m,s)){
                       i = d.length;
                    }else{
                       i = i + pas;
                       pas = 40;
                       s = "";
                    }
                    indice++;
                 }
            }
            
            if(indice >= this.n){
              return -1;
            }else{
              return indice;
            }
            
          }
          
          
          public boolean memeMots(String m, String s){
              int i =0;
              if(m.length() == s.length()){
                while(i!=m.length() && m.charAt(i)==s.charAt(i)){
                     i++;
                }
                return i == m.length();
              }else{
                return false;
              }
          
          }
      
                // d.add(m);
    /*public int indiceMot(String m){
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

    }*/

    //andy fais ça
    public String motIndice(int i){
        String motStock = "";
        String msgErreur = "String out of bound";
        int compteur = 0;
        int occ = 0;

        if(i>=0 && i < n){
            if(i < nbMots()){
                while(compteur != d.length && occ!=i){
                    compteur++;
                    if(d[compteur] == 0){
                        occ++;
                        while(d[compteur] ==0){
                            compteur++;
                        }
                    }

                }


                while(d[compteur] != 0){
                    motStock = motStock + d[compteur];
                    compteur++;
                }
                return motStock;
            }
            else{
                return msgErreur;
            }
        } 
        else{
            return msgErreur;
        }
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
    public void afficher(){
        int i = 0 ;
        while(i!=this.nbMots()){
            System.out.println(motIndice(i));
            i++;
        }
    }
}

	


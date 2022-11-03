package inf353;

import java.io.FileNotFoundException;
import java.io.*; 

public class MatriceIndexNaive implements MatriceIndex{
    public int ndoc;
    public int nterm;
    int[][] matrice;

    public MatriceIndexNaive(int ndoc, int nterm){
        this.ndoc = ndoc ;
        this.nterm =nterm ;
        matrice = new int[ndoc][nterm];
        int i = 0;
        while(i != ndoc){ //matrice.length
            int j = 0;
            while(j != nterm){ //matrice[i].length
                matrice[i][j] = 0;
                j++;
            }           
            i++;
        }
    }

    @Override
    public void sauver(String nomDeFichier) throws FileNotFoundException {
        int i = 0 ;
        // TODO Auto-generated method stub
        File file = new File("../resources/" + nomDeFichier + ".txt");
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
            
            fw.write(""+ndoc);
            fw.newLine();
            fw.write(""+ nterm);
            fw.newLine();
            fw.newLine();

            while(i != ndoc){
                int j = 0;
                while(j != nterm){
                    fw.write(""+matrice[i][j]);
                    fw.newLine();  
                    j++;
                }
                //fw.append(';');
            
                i++;
                
            }
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    @Override
    public int val(int ndoc, int nterm) {
        // TODO Auto-generated method stub
        return matrice[ndoc][nterm];
    }

    @Override
    public void incremente(int ndoc, int nterm) {
        // TODO Auto-generated method stub
        matrice[ndoc][nterm]++;
    }

    @Override
    public void affecte(int ndoc, int nterm, int val) {
        // TODO Auto-generated method stub
        matrice[ndoc][nterm] = val;
    }
    
}

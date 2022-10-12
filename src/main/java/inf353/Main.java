package inf353;

public class Main{
    public static void main(String[] args) {
        DictionnaireNaif dictionnaire = new DictionnaireNaif(3);
        dictionnaire.d[0] = 'T';
        dictionnaire.d[1] = 'e';
        dictionnaire.d[2] = 's';
        dictionnaire.d[3] = 0;
        dictionnaire.d[4] = 't';
        
        dictionnaire.d[7] = 0;
        dictionnaire.d[8] = ' ';
        dictionnaire.d[9] = 0 ;
        dictionnaire.d[10] = 0 ;
        dictionnaire.d[11] = 0 ;
        dictionnaire.d[12] = 0 ;


        //dictionnaire.d[10] = 'g';
        //dictionnaire.d[11] = 0;

        System.out.println(dictionnaire.("ebas"));    

    }
}
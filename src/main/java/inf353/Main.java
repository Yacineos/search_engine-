package inf353;

public class Main{
    public static void main(String[] args) {
        DictionnaireNaif dictionnaire = new DictionnaireNaif(4);
        dictionnaire.vider();
        dictionnaire.d[0] = 'T';
        dictionnaire.d[1] = 'e';
        dictionnaire.d[2] = 's';
        dictionnaire.d[4] = 't';
        dictionnaire.d[8] = 'e';
        dictionnaire.d[9] = 't';
        dictionnaire.d[12] = ' ';
        
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
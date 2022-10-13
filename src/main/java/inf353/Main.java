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
        

        System.out.println(dictionnaire.indiceMot("es"));    

    }
}
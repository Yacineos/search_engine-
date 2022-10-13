package symbaa ;
import static org.junit.jupiter.api.assertions.* ;
public class TestDictionnaireNaif () {
    public int indiceMotTest (String m){
        @TestindiceMot
        void doesExiste () {
            DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
            assertequals (i-m.lenght(), "tes") ;
        }
        void doesNotExiste () {
            DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
            assertequals (-1, "te") ;
    }
    public String motIndiceTest (int i) {
        @TestmotIndice
        void dansDictionnaire (){
            DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
            assertequals("tes",1) ;
            
        }
    }
    public boolean contientTest (String m){
        @Testcontient
        void contient () {
            DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
            asserttrue("tes") ;
            
        }
        void contientPas () {
            DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
            assertfalse("te") ;
            
        }

    }
    public int nbMotsTest(){
        @TestnbMot
        void nbmot (){
        DictionnaireNaif dictionnaire = new DictionnaireNaif () ;
        assertequals(0) ;}

    }
    public boolean contientPrefixe(String p) {
        @TestcontienPrefixe
        void contientPrfx (){
             DictionnaireNaif dictionnaire = new DictionnaireNaif () ;

        assertfalse("tes") ;}
        void contientPasPrfx (){
             DictionnaireNaif dictionnaire = new DictionnaireNaif () ;

        assertfalse("tes") ;}
    }
}
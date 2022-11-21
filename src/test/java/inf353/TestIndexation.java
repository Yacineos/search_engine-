package inf353;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestIndexation {
        
    @Test
    public void testDicD() throws java.io.IOException {
        Indexation i = new Indexation(System.getProperty("user.dir") + "/src/test/resources/dossierTest" , System.getProperty("user.dir") + "/src/test/resources" , "matriceTest", "documentsTest", "termesTest");
        
        assertEquals(i.dicD.nbMots(),3);

        assertTrue(i.dicD.contient("1.txt"));
        assertTrue(i.dicD.contient("2.txt"));
        assertTrue(i.dicD.contient("3.txt"));
    }

    @Test
    public void testDicT() throws java.io.IOException {
        Indexation i = new Indexation(System.getProperty("user.dir") + "/src/test/resources/dossierTest" , System.getProperty("user.dir") + "/src/test/resources" , "matriceTest", "documentsTest", "termesTest");

        assertEquals(i.dicT.nbMots(),3);

        assertTrue(i.dicT.contient("Angeline"));
        assertTrue(i.dicT.contient("Basma"));
        assertTrue(i.dicT.contient("Sara"));
    }

    @Test
    public void testMatrice() throws java.io.IOException {
        Indexation i = new Indexation(System.getProperty("user.dir") + "/src/test/resources/dossierTest" , System.getProperty("user.dir") + "/src/test/resources" , "matriceTest", "documentsTest", "termesTest");


        assertEquals(i.m.ndoc,3);
        assertEquals(i.m.nterm,3);

        assertEquals(  i.m.val(i.dicD.indiceMot("1.txt"),i.dicT.indiceMot("Angeline"))  ,  4);
        assertEquals(  i.m.val(i.dicD.indiceMot("1.txt"),i.dicT.indiceMot("Basma"))  ,  1);
        assertEquals(  i.m.val(i.dicD.indiceMot("1.txt"),i.dicT.indiceMot("Sara"))  ,  1);

        assertEquals(  i.m.val(i.dicD.indiceMot("2.txt"),i.dicT.indiceMot("Angeline"))  ,  1);
        assertEquals(  i.m.val(i.dicD.indiceMot("2.txt"),i.dicT.indiceMot("Basma"))  ,  4);
        assertEquals(  i.m.val(i.dicD.indiceMot("2.txt"),i.dicT.indiceMot("Sara"))  ,  0);

        assertEquals(  i.m.val(i.dicD.indiceMot("3.txt"),i.dicT.indiceMot("Angeline"))  ,  1);
        assertEquals(  i.m.val(i.dicD.indiceMot("3.txt"),i.dicT.indiceMot("Basma"))  ,  1);
        assertEquals(  i.m.val(i.dicD.indiceMot("3.txt"),i.dicT.indiceMot("Sara"))  ,  5);
    }

    @Test
    public void testSauver() throws java.io.IOException {
        Indexation i = new Indexation(System.getProperty("user.dir") + "/src/test/resources/dossierTest", System.getProperty("user.dir") + "/src/test/resources" , "matriceTest", "documentsTest", "termesTest");
        
        File m = new File(i.pathSauvegarde + "/matriceTest.txt");
        File d = new File(i.pathSauvegarde + "/documentsTest.txt");
        File t = new File(i.pathSauvegarde + "/termesTest.txt");
        
        assertNotNull(m);
        assertNotNull(d);
        assertNotNull(t);
    }
}

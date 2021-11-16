import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AppTest {

    @Test
    public void testNombreMaxOK() {
        Zoo zoo = new Zoo();
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        Exception exc = null;
        try {
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

        } catch (LimiteVisiteurException e) {
            exc = e;
        }
        assertNull(exc);
    }

    @Test
    public void testNombreMaxKO() {
        Zoo zoo = new Zoo();
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        Exception exc = null;
        try {
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

        } catch (LimiteVisiteurException e) {
            exc = e;
        }
        assertNotNull(exc);
        assertEquals(LimiteVisiteurException.class, exc.getClass());
    }
}
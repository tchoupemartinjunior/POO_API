import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
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

    @Test
    public void testComSecteur(){
        Zoo zoo = new Zoo();
        Exception exc = null;
        Secteur s1 = new Secteur(TypeAnimal.CHAT);
        Secteur s2 = new Secteur(TypeAnimal.CHAT);
       try {
           s1.ajouterAnimal(new Chat("bibi", TypeAnimal.CHAT));
           s1.ajouterAnimal(new Chat("bibo", TypeAnimal.CHAT));
           s1.ajouterAnimal(new Chat("boba", TypeAnimal.CHAT));
       }catch (AnimalDansMauvaisSecteurException e) {
           exc = e;
       }
        try {
            s2.ajouterAnimal(new Chat("bibu", TypeAnimal.CHAT));
            s2.ajouterAnimal(new Chat("biby", TypeAnimal.CHAT));

        }catch (AnimalDansMauvaisSecteurException e) {
            exc = e;
        }
        System.out.println(s1 +""+ s2);
        assertEquals(1, new ComSecteur().compare(s1,s2));
        assertEquals(-1, new ComSecteur().compare(s2,s1));
        assertEquals(0, new ComSecteur().compare(s1,s1));
        assertEquals(null, new ComSecteur().compare(new Secteur(TypeAnimal.CHAT),new Secteur(TypeAnimal.CHAT)));
    }
}
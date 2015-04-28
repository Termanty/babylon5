package ohtumini.domain;

import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sssoinin
 */
public class BibTeXGeneratorJUnitTest {

    private BibTeXGenerator test;
    private HashMap<String, String> testFields;

    @Before
    public void setUp() {
        test = new BibTeXGenerator();
        testFields = new HashMap();
    }

    @Test
    public void replaceAeRight() {
        testFields.put("referencetype", "referencetype");
        testFields.put("pubkey", "id");
        testFields.put("title", "Ääkkoset");

        assertEquals("@referencetype{id,\ntitle = {\\\"{A}\\\"{a}kkoset},\n}", test.generateBibtex(testFields));
    }

    @Test
    public void replaceOeRight() {
        testFields.put("referencetype", "referencetype");
        testFields.put("pubkey", "id");
        testFields.put("title", "Öökkoset");

        assertEquals("@referencetype{id,\ntitle = {\\\"{O}\\\"{o}kkoset},\n}", test.generateBibtex(testFields));
    }

    @Test
    public void replaceAaRight() {
        testFields.put("referencetype", "referencetype");
        testFields.put("pubkey", "id");
        testFields.put("title", "Ååkkoset");

        assertEquals("@referencetype{id,\ntitle = {\\AA\\aakkoset},\n}", test.generateBibtex(testFields));
    }
    
        @Test
    public void putsReferencetypeAndIdInTheRightPlaces() {
        testFields.put("referencetype", "referencetype");
        testFields.put("pubkey", "id");

        assertEquals("@referencetype{id,\n}", test.generateBibtex(testFields));
    }
}

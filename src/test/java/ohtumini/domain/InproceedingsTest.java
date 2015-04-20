package ohtumini.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maparvam
 */
public class InproceedingsTest {

    public InproceedingsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void bibtexContainsAllTheFields() {
        Inproceedings inproceedings = new Inproceedings();
        inproceedings.setTitle("How To Dance Without Legs");
        inproceedings.setAuthor("Leglez");
        inproceedings.setPubYear("1876");
        inproceedings.setPubKey("key3");
        inproceedings.setNote("Note3");
        inproceedings.setBookTitle("All About Dance");
        inproceedings.setPubMonth("March");
        inproceedings.setOrganisation("DanceCorp");
        inproceedings.setEditor("JohnnyBoy");
        inproceedings.setVolume("volume1");
        inproceedings.setSeries("UltimateDanceSeries");
        inproceedings.setPages("62");
        inproceedings.setAddress("DanceLane");
        inproceedings.setPublisher("DancePub");

        String inproceedingsBibtex = inproceedings.toBibtex();

        assertTrue(inproceedingsBibtex.contains("How To Dance Without Legs"));
        assertTrue(inproceedingsBibtex.contains("Leglez"));
        assertTrue(inproceedingsBibtex.contains("1876"));
        assertTrue(inproceedingsBibtex.contains("key3"));
        assertTrue(inproceedingsBibtex.contains("Note3"));
        assertTrue(inproceedingsBibtex.contains("All About Dance"));
        assertTrue(inproceedingsBibtex.contains("March"));
        assertTrue(inproceedingsBibtex.contains("DanceCorp"));
        assertTrue(inproceedingsBibtex.contains("JohnnyBoy"));
        assertTrue(inproceedingsBibtex.contains("volume1"));
        assertTrue(inproceedingsBibtex.contains("UltimateDanceSeries"));
        assertTrue(inproceedingsBibtex.contains("62"));
        assertTrue(inproceedingsBibtex.contains("DanceLane"));
        assertTrue(inproceedingsBibtex.contains("DancePub"));


    }
}

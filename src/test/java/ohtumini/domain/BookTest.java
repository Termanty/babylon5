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
public class BookTest {
    
    public BookTest() {
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
    public void bibtexContainsAllTheFields(){
        Book book = new Book();
        book.setTitle("Book1");
        book.setAuthor("Tolkien");
        book.setPubYear("2015");
        book.setPubKey("key2");
        book.setEdition("Edition1");
        book.setPublisher("mina");
        book.setNote("note2");
        book.setVolume("Volume1");
        book.setSeries("Lotrot");
        book.setAddress("Shire");
        book.setPubMonth("July");
        
        String bookBibtex = book.toBibtex();
        
        assertTrue(bookBibtex.contains("Book1"));
        assertTrue(bookBibtex.contains("Tolkien"));
        assertTrue(bookBibtex.contains("2015"));
        assertTrue(bookBibtex.contains("key2"));
        assertTrue(bookBibtex.contains("Edition1"));
        assertTrue(bookBibtex.contains("mina"));
        assertTrue(bookBibtex.contains("note2"));
        assertTrue(bookBibtex.contains("Volume1"));
        assertTrue(bookBibtex.contains("Lotrot"));
        assertTrue(bookBibtex.contains("Shire"));
        assertTrue(bookBibtex.contains("July"));
        
    }

}

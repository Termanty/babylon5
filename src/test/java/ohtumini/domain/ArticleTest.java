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
public class ArticleTest {
    
    public ArticleTest() {
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
        Article article = new Article();
        article.setTitle("Juhuu");
        article.setAuthor("mina");
        article.setPubYear("2015");
        article.setPubMonth("May");
        article.setPages("14");
        article.setNumber("1");
        article.setPubKey("key");
        article.setJournal("sadfdas");
        article.setNote("note1");
        article.setVolume("volume4");
        
        String articleBibtex = article.toBibtex();
        
        assertTrue(articleBibtex.contains("Juhuu"));
        assertTrue(articleBibtex.contains("mina"));
        assertTrue(articleBibtex.contains("2015"));
        assertTrue(articleBibtex.contains("May"));
        assertTrue(articleBibtex.contains("14"));
        assertTrue(articleBibtex.contains("1"));
        assertTrue(articleBibtex.contains("key"));
        assertTrue(articleBibtex.contains("sadfdas"));
        assertTrue(articleBibtex.contains("note1"));
        assertTrue(articleBibtex.contains("volume4"));
        
    }
}
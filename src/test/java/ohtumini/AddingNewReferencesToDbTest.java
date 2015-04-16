package ohtumini;

import ohtumini.domain.Article;
import ohtumini.domain.Book;
import ohtumini.domain.Inproceedings;
import ohtumini.domain.Reference;
import ohtumini.repository.ReferenceRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AddingNewReferencesToDbTest {
      
    @Autowired
    ReferenceRepository refRepo;

    @Test
    public void testSaveArticle() {
        Article article = new Article();
        article.setTitle("Juhuu");
        article.setAuthor("mina");
        article.setPubYear("2015");
        article.setPubMonth("May");
        article.setPages("14");
        article.setNumber("1");
        article.setPubKey("key");
        article.setJournal("sadfdas");
        
        refRepo.save(article);
        
        Reference retrieved = refRepo.findByTitle("Juhuu");
        assertNotNull(retrieved);
        assertEquals("mina", retrieved.getAuthor());
        assertEquals("ARTICLE", retrieved.getReferenceType());
        Article retri = (Article)retrieved;
        assertEquals("14", retri.getPages());
    }
    
    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setTitle("Book1");
        book.setAuthor("Tolkien");
        book.setPubYear("2015");
        book.setPubKey("key2");
        book.setEditor("Editer");
        book.setPublisher("mina");
        
        
        refRepo.save(book);
        
        Reference retrieved = refRepo.findByTitle("Book1");
        assertNotNull(retrieved);
        assertEquals("Tolkien", retrieved.getAuthor());
        assertEquals("BOOK", retrieved.getReferenceType());
        assertEquals("Book1", retrieved.getTitle());
    }
    
    @Test
    public void testSaveInproceedings(){
        Inproceedings inproceedings = new Inproceedings();
        inproceedings.setTitle("How To Dance Without Legs");
        inproceedings.setAuthor("Leglez");
        inproceedings.setPubYear("1876");
        inproceedings.setPubKey("key3");
        inproceedings.setNote("Note3");
    }

}

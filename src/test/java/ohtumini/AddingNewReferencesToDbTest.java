package ohtumini;

import ohtumini.domain.Article;
import ohtumini.domain.Book;
import ohtumini.repository.ReferenceRepository;
import org.junit.Test;
import static org.junit.Assert.*;
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
        
        Article retrieved = refRepo.findByTitle("Juhuu");
        assertNotNull(retrieved);
        assertEquals("mina", retrieved.getAuthor());
        assertEquals("14", retrieved.getPages());
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
        
        Book retrieved = refRepo.findByEditor("Editer");
        assertNotNull(retrieved);
        assertEquals("Tolkien", retrieved.getAuthor());
        assertEquals("Book1", retrieved.getTitle());
    }

}

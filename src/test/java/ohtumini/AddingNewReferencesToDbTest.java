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
        article.setNote("note1");
        
        refRepo.save(article);
        
        Reference retrieved = refRepo.findByTitle("Juhuu");
        assertNotNull(retrieved);
        assertEquals("ARTICLE", retrieved.getReferenceType());
        
        Article retri = (Article)retrieved;
        
        assertEquals("mina", retri.getAuthor());
        assertEquals("Juhuu", retri.getTitle());
        assertEquals("2015", retri.getPubYear());
        assertEquals("May", retri.getPubMonth());
        assertEquals("14", retri.getPages());
        assertEquals("1", retri.getNumber());
        assertEquals("key", retri.getPubKey());
        assertEquals("sadfdas", retri.getJournal());
        assertEquals("note1", retri.getNote());
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
        book.setNote("note2");
            
        refRepo.save(book);
        
        Reference retrieved = refRepo.findByTitle("Book1");
        assertNotNull(retrieved);
        assertEquals("BOOK", retrieved.getReferenceType());
        
        Book retri = (Book)retrieved;
        
        assertEquals("Tolkien", retri.getAuthor());
        assertEquals("Book1", retri.getTitle());
        assertEquals("2015", retri.getPubYear());
        assertEquals("key2", retri.getPubKey());
        assertEquals("Editer", retri.getEditor());
        assertEquals("mina", retri.getPublisher());
        assertEquals("note2", retri.getNote());
        
    }
    
    @Test
    public void testSaveInproceedings(){
        Inproceedings inproceedings = new Inproceedings();
        inproceedings.setTitle("How To Dance Without Legs");
        inproceedings.setAuthor("Leglez");
        inproceedings.setPubYear("1876");
        inproceedings.setPubKey("key3");
        inproceedings.setNote("Note3");
        inproceedings.setBookTitle("All About Dance");
        inproceedings.setPubMonth("March");
        inproceedings.setOrganisation("DanceCorp");
        
        refRepo.save(inproceedings);
        
        Reference retrieved = refRepo.findByTitle("How To Dance Without Legs");
        assertNotNull(retrieved);
        assertEquals("INPROCEEDINGS", retrieved.getReferenceType());
        
        Inproceedings retri = (Inproceedings) retrieved;
        
        assertEquals("How To Dance Without Legs", retri.getTitle());
        assertEquals("Leglez", retri.getAuthor());
        assertEquals("1876", retri.getPubYear());
        assertEquals("key3", retri.getPubKey());
        assertEquals("Note3", retri.getNote());
        assertEquals("All About Dance", retri.getBookTitle());
        assertEquals("March", retri.getPubMonth());
        assertEquals("DanceCorp", retri.getOrganisation());
                
    }

}

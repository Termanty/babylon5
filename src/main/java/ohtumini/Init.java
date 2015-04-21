package ohtumini;

import ohtumini.domain.Article;
import ohtumini.domain.Book;
import ohtumini.domain.Inproceedings;
import ohtumini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Init {

    
    private Book book;
    private Article article;
    private Inproceedings inproceeding;
    
    @Autowired
    private ReferenceRepository refrep;

    public Init() {
        book = new Book();
        book.setAuthor("Beck, Kent and Andres, Cynthia");
        book.setTitle("Extreme Programming Explained: Embrace Change (2nd Edition)");
        book.setPublisher("Addison-Wesley Professional");
        book.setPubYear("2004");
        refrep.save(book);

        article = new Article();
        article.setAuthor("Allan Collins and John Seely Brown and Ann Holum");
        article.setTitle("Cognitive apprenticeship: making thinking visible");
        article.setJournal("American Educator");
        article.setPubYear("1991");
        article.setVolume("6");
        refrep.save(article);

        inproceeding = new Inproceedings();
        inproceeding.setAuthor("Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti");
        inproceeding.setTitle("Extreme Apprenticeship Method in Teaching Programming for Beginners.");
        inproceeding.setPubYear("2011");
        inproceeding.setBookTitle("SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        refrep.save(inproceeding);
    }
    
    
}


package ohtumini.repository;

import ohtumini.domain.Article;
import ohtumini.domain.Book;
import ohtumini.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {

    public Article findByTitle(String title);
    public Book findByEditor(String editor);
    
    // custom queries to db will be writen here
    
}


package ohtumini.repository;

import ohtumini.domain.Article;
//import ohtumini.domain.Book;
import ohtumini.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {

    public Reference findByTitle(String title);
    //public Book findByEditor(String editor);
    public Reference findByPubKey(String pubkey);
    // custom queries to db will be writen here
    
}

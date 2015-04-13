
package ohtumini.repository;

import ohtumini.domain.ArticleReference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<ArticleReference, Long> {
    
    // custom queries to db will be writen here
    
}

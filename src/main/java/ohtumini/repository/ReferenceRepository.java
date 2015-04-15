
package ohtumini.repository;

import ohtumini.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    
    // custom queries to db will be writen here
    
}

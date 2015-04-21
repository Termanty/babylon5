/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtumini.domain;

import ohtumini.repository.ReferenceRepository;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
/**
 *
 * @author sssoinin
 */
public class IdGeneratorJUnitTest {
    
    public IdGeneratorJUnitTest() {
    }
    
   
   @Test
    
    public void checkUniquenessReturnsTrueWhenPubKeyIsUnique(){
       ReferenceRepository mockrefRepo = mock(ReferenceRepository.class); 
       IdGenerator test = new IdGenerator(mockrefRepo);
       when(mockrefRepo.findByPubKey("1234")).thenReturn(null);
       
       assertTrue(test.checkUniqueness("1234"));
    
    }

    public void checkUniquenessReturnsFalseWhenPubKeyIsNotUnique(){
        ReferenceRepository mockrefRepo = mock(ReferenceRepository.class); 
       IdGenerator test = new IdGenerator(mockrefRepo);
       when(mockrefRepo.findByPubKey("1234")).thenReturn(new Article());
        
       assertFalse(test.checkUniqueness("1234"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtumini.domain;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sssoinin
 */
public class BibTeXGeneratorJUnitTest {
    
   private BibTeXGenerator test;
   private HashMap<String, String> testFields;
    @Before
    public void setUp() {
        test = new BibTeXGenerator ();
        testFields=new HashMap();
    
    }
    
   @Test
   public void replaceAeRight(){
       testFields.put("referencetype","referencetype");
       testFields.put("id","id");
       testFields.put("title", "ääkkoset");
       
       assertEquals("@referencetype{id,\ntitle = {\\\"{a}\\\"{a}kkoset},\n}",test.generateBibtex(testFields)) ;
   
   }
   
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

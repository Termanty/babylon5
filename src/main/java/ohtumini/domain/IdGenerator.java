/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtumini.domain;

import ohtumini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;


 
public class IdGenerator {
    @Autowired
    ReferenceRepository refRep;
    
    public IdGenerator(ReferenceRepository refRep){
        this.refRep=refRep;
    }
    
    public String generateId (String author, String year){
        
        return "";    
    }
    
    public boolean checkUniqueness (String pubkey){
        if(refRep.findByPubKey(pubkey)== null)
            return true;
        
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtumini.domain;

import java.util.HashMap;

/**
 *
 * @author juma
 */
public class BibTeXGenerator {
    
    public String generateBibtex(HashMap<String,String> allFields) {
        StringBuilder sb = new StringBuilder();
        
        for (String key : allFields.keySet()) {
            sb.append(key)
        }
        return "";
    }
}

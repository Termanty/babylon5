
package ohtumini.domain;

import java.util.HashMap;

public class BibTeXGenerator {
    private HashMap<String,String> specialChars;
    
    public BibTeXGenerator() {
        createSpecialCharacterMap();
    }
    
    public String generateBibtex(HashMap<String,String> allFields) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("@").append(allFields.get("referencetype")).append("{")
                .append(allFields.get("pubkey")).append(",\n");
        
        for (String nameOfField : allFields.keySet()) {
            if(allFields.get(nameOfField)==null
                    || allFields.get(nameOfField).equals("")
                    || nameOfField.equals("referencetype") 
                    || nameOfField.equals("id")  
                    || nameOfField.equals("pubkey")) {
                continue;
            }
            sb.append(nameOfField).append(" = {").append(fixSpecialCharacters(allFields.get(nameOfField))).append("},\n");
        }
        
        sb.append("}");
        System.out.println(sb);
        return sb.toString();
    }
    
    private String fixSpecialCharacters(String normalText) {
        String fixed = normalText;
        
        for (String charToReplace : specialChars.keySet()) {
            fixed = fixed.replace(charToReplace, specialChars.get(charToReplace));
        }
        
        return fixed;
    }
    
    private void createSpecialCharacterMap() {
        this.specialChars=new HashMap();
        
        this.specialChars.put("ä", "\\\"{a}");
        this.specialChars.put("ö", "\\\"{o}");
        this.specialChars.put("å", "\\aa");
        this.specialChars.put("Ä", "\\\"{A}");
        this.specialChars.put("Ö", "\\\"{O}");
        this.specialChars.put("Å", "\\AA");
    }
}

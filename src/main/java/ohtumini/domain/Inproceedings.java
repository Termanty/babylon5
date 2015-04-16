
package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Inproceedings extends Reference {
    
    private String bookTitle;
    private String pubMonth;
    private String organisation;
    
    public Inproceedings(){
         super("INPROCEEDINGS");
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    
    public String toBibtex() {
        HashMap<String, String> allFields = new HashMap();
        allFields.put("title", this.getTitle());
        allFields.put("author", this.getAuthor());
        allFields.put("id", "" + this.getId());
        allFields.put("pubyear", this.getPubYear());
        allFields.put("note", this.getNote());
        allFields.put("pubkey", this.getPubKey());
        allFields.put("referencetype", this.getReferenceType());
        allFields.put("booktitle", this.getBookTitle());
        allFields.put("pubmonth", this.getPubMonth());
        allFields.put("organisation", this.getOrganisation());

        BibTeXGenerator bg = new BibTeXGenerator();

        return bg.generateBibtex(allFields);
    }
    
}

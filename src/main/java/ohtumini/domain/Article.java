package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Article extends Reference {

    @NotBlank
    private String journal;
    @NotBlank
    private String volume;
    private String number;
    private String pages;
    private String pubMonth;

    public Article() {
        super("ARTICLE");
    }

    public String getJournal() {
        return journal;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }

    public String toBibtex() {
        HashMap<String, String> allFields = new HashMap();
        allFields.put("journal", this.getJournal());
        allFields.put("volume", this.getVolume());
        allFields.put("number", this.getNumber());
        allFields.put("pages", this.getPages());
        allFields.put("title", this.getTitle());
        allFields.put("author", this.getAuthor());
        allFields.put("id", "" + this.getId());
        allFields.put("pubyear", this.getPubYear());
        allFields.put("note", this.getNote());
        allFields.put("pubkey", this.getPubKey());
        allFields.put("referencetype", this.getReferenceType());
        allFields.put("pubmonth", this.getPubMonth());

        BibTeXGenerator bg = new BibTeXGenerator();

        return bg.generateBibtex(allFields);
    }

}

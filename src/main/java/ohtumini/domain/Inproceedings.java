package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.Entity;

@Entity
public class Inproceedings extends Reference {

    private String bookTitle;
    private String editor;
    private String volume;
    private String series;
    private String pages;
    private String address;
    private String pubMonth;
    private String organisation;
    private String publisher;
    
    public Inproceedings(){
         super("INPROCEEDINGS");
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
        allFields.put("editor", this.editor);
        allFields.put("publisher", this.publisher);
        allFields.put("volume", this.volume);
        allFields.put("series", this.series);
        allFields.put("pages", this.pages);
        allFields.put("address", this.address);

        BibTeXGenerator bg = new BibTeXGenerator();

        return bg.generateBibtex(allFields);
    }
}

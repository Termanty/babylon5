package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book extends Reference {

    @NotBlank
    private String publisher;
    private String volume;
    private String series;
    private String address;
    private String edition;
    private String pubMonth;

    public Book() {
        super("BOOK");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEdition() {
        return edition;
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
        allFields.put("edition", this.getEdition());
        allFields.put("publisher", this.getPublisher());
        allFields.put("volume", this.getVolume());
        allFields.put("series", this.getSeries());
        allFields.put("address", this.getAddress());
        allFields.put("pubmonth", this.getPubMonth());

        BibTeXGenerator bg = new BibTeXGenerator();

        return bg.generateBibtex(allFields);
    }

}

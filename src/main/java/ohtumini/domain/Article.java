package ohtumini.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Article extends Reference {


  //  private String[] orderOfFields = {"author", "title", "journal", "year", "volume", "number", "pages", "month", "note", "key"};
  //  private String[] requiredFields = {"author", "title", "journal", "year", "volume"};

    private String journal;
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
        this.volume=volume;
    }

    public void setNumber(String number) {
        this.number=number;
    }

    public void setPages(String pages) {
        this.pages=pages;
    }

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }
    
    

}

package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class ArticleReference extends AbstractPersistable<Long> {

    private String[] orderOfFields = {"author", "title", "journal", "year", "volume", "number", "pages", "month", "note", "key"};
    private String[] requiredFields = {"author", "title", "journal", "year", "volume"};

    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String journal;
    @Column
    private String year;
    @Column
    private String volume;
    @Column
    private String number;
    @Column
    private String pages;
    @Column
    private String month;
    @Column
    private String note;
    @Column
    private String key;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public String getYear() {
        return year;
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

    public String getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

    public String getKey() {
        return key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setYear(String year) {
        this.year=year;
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

    public void setMonth(String month) {
        this.month=month;
    }

    public void setNote(String note) {
        this.note=note;
    }

    public void setKey(String key) {
        this.key=key;
    }

}

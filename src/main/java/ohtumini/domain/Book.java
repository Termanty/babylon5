package ohtumini.domain;

import java.util.HashMap;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Book extends Reference {

    private String publisher;
    private String editor;

    public Book() {
        super("BOOK");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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
        allFields.put("editor", this.getEditor());
        allFields.put("publisher", this.getPublisher());

        BibTeXGenerator bg = new BibTeXGenerator();

        return bg.generateBibtex(allFields);
    }

}

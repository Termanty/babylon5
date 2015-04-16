
package ohtumini.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Book extends Reference{
    
    private String publisher;
    private String editor;
    
    public Book(){
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

}

package henrique.matheus.librarymanager.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name="BOOKS")
public class BookModel extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorModel author;
    public String name;
    public int pages;
    public ZonedDateTime dateTimeReleased;

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDateTimeReleased() {
        return dateTimeReleased;
    }

    public void setDateTimeReleased(ZonedDateTime dateTimeReleased) {
        this.dateTimeReleased = dateTimeReleased;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

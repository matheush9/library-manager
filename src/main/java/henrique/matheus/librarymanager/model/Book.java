package henrique.matheus.librarymanager.model;

import java.time.ZonedDateTime;

public class Book extends BaseModel {
    public String name;
    public Author author;
    public int pages;
    public ZonedDateTime dateTimeReleased;
}

package henrique.matheus.librarymanager.model;

import java.time.ZonedDateTime;

public class BookModel extends BaseModel {
    public String name;
    public AuthorModel authorModel;
    public int pages;
    public ZonedDateTime dateTimeReleased;
}

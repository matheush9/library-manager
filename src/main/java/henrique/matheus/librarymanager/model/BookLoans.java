package henrique.matheus.librarymanager.model;

import java.time.ZonedDateTime;

public class BookLoans extends BaseModel {
    public String borrowerName;
    public ZonedDateTime borrowedDateTime;
    public Book book;
}

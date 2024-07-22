package henrique.matheus.librarymanager.model;

import java.time.ZonedDateTime;

public class BookLoansModel extends BaseModel {
    public String borrowerName;
    public ZonedDateTime borrowedDateTime;
    public BookModel bookModel;
}

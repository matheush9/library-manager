package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.BookModel;

public interface BookController {
    public BookModel getBook(String id);
    public Boolean addBook(BookModel bookModel);
    public BookModel updateBook(String id);
    public Boolean deleteBook(String id);
}

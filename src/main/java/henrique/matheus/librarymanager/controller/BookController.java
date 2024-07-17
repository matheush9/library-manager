package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.Book;

public interface BookController {
    public Book GetBook(String id);
    public Boolean AddBook(Book book);
    public Book UpdateBook(String id);
    public Boolean DeleteBook(String id);
}

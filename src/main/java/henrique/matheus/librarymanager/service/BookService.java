package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.Book;

public interface BookService {
    public Book GetBook(String id);
    public Boolean AddBook(Book book);
    public Book UpdateBook(String id);
    public Boolean DeleteBook(String id);
}

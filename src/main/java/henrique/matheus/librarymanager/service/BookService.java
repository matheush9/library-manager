package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.BookModel;

public interface BookService {
    public BookModel getBookById(String id);
    public Boolean addBook(BookModel bookModel);
    public BookModel updateBook(String id);
    public Boolean deleteBook(String id);
}

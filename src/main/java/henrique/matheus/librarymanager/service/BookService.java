package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.BookModel;

import java.util.List;
import java.util.UUID;

public interface BookService {
    public BookModel getBookById(UUID id);
    public List<BookModel> getAllBooks();
    public Boolean bookExists(UUID id);
    public BookModel addBook(BookModel bookModel);
    public BookModel updateBook(UUID id, BookModel bookModel);
    public void deleteBook(UUID id);
}

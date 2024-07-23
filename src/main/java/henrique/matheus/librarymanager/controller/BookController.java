package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BookController {
    public ResponseEntity<Object> getBook(UUID id);
    public ResponseEntity<List<BookModel>> getAllBooks();
    public ResponseEntity<BookModel> addBook(BookModel bookModel);
    public ResponseEntity<Object> updateBook(UUID id, BookModel bookModel);
    public ResponseEntity<Object> deleteBook(UUID id);
}

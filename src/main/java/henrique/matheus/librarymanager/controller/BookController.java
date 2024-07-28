package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.BookDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BookController {
    public ResponseEntity<Object> getBook(UUID id);
    public ResponseEntity<List<BookDto>> getAllBooks();
    public ResponseEntity<BookDto> addBook(BookDto bookDto);
    public ResponseEntity<Object> updateBook(UUID id, BookDto bookDto);
    public ResponseEntity<Object> deleteBook(UUID id);
}

package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.BookRequestDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.dtos.BookSimpleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BookController {
    public ResponseEntity<Object> getBook(UUID id);
    public ResponseEntity<List<BookSimpleDTO>> getAllBooks();
    public ResponseEntity<BookResponseDto> addBook(BookRequestDto bookRequestDto);
    public ResponseEntity<Object> updateBook(UUID id, BookRequestDto bookRequestDto);
    public ResponseEntity<Object> deleteBook(UUID id);
}

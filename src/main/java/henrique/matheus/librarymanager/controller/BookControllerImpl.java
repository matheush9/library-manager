package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.BookRequestDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.dtos.BookSimpleDTO;
import henrique.matheus.librarymanager.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable(value="id") UUID id) {
        var bookExists = bookService.bookExists(id);
        if (!bookExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        var bookDto = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookSimpleDTO>> getAllBooks() {
        var bookList = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequestDto));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value="id") UUID id,
                                             @RequestBody BookRequestDto bookRequestDto) {
        var bookExists = bookService.bookExists(id);
        if (!bookExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, bookRequestDto));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(UUID id) {
        var bookExists = bookService.bookExists(id);
        if (!bookExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book delete successfully!");
    }
}

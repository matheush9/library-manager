package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.BookModel;
import henrique.matheus.librarymanager.service.BookService;

import org.springframework.beans.BeanUtils;
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
        var bookModel = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookModel);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> getAllBooks() {
        var bookList = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    @PostMapping("/books")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
        var newBookModel = new BookModel();
        BeanUtils.copyProperties(bookModel, newBookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(newBookModel));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value="id") UUID id,
                                             @RequestBody BookModel bookModel) {
        var bookExists = bookService.bookExists(id);
        if (!bookExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, bookModel));
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

package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.BookModel;
import henrique.matheus.librarymanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/{id}")
    public ResponseEntity<BookModel> getBook(@PathVariable(value="id") String id) {
        Optional<BookModel> bookO = bookService.
    }

    @Override
    public Boolean addBook(BookModel bookModel) {
        return null;
    }

    @Override
    public BookModel updateBook(String id) {
        return null;
    }

    @Override
    public Boolean deleteBook(String id) {
        return null;
    }
}

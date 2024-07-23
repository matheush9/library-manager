package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.BookModel;
import henrique.matheus.librarymanager.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public BookModel getBookById(UUID id) {
        return bookRepository.findById(id).get();
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public Boolean bookExists(UUID id) {
        return bookRepository.existsById(id);
    }

    public BookModel addBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public BookModel updateBook(UUID id, BookModel bookModel) {
        var newBook = getBookById(id);
        BeanUtils.copyProperties(bookModel, newBook, "id");
        return bookRepository.save(newBook);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
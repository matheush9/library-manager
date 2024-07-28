package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.AuthorDto;
import henrique.matheus.librarymanager.dtos.BookDto;
import henrique.matheus.librarymanager.model.AuthorModel;
import henrique.matheus.librarymanager.model.BookModel;
import henrique.matheus.librarymanager.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public BookDto getBookById(UUID id) {
        var bookModel = bookRepository.findById(id).get();
        return new BookDto(
                bookModel.getName(),
                bookModel.getPages(),
                bookModel.getDateTimeReleased(),
                bookModel.getDateTimeCreated(),
                bookModel.getDateTimeModified(),
                authorService.getAuthorById(bookModel.getAuthor().getId()));
    }

    public List<BookDto> getAllBooks() {
        var bookModels = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookModel bookModel: bookModels) {
            BookDto bookDto = new BookDto(
                    bookModel.getName(),
                    bookModel.getPages(),
                    bookModel.getDateTimeReleased(),
                    bookModel.getDateTimeCreated(),
                    bookModel.getDateTimeModified(),
                    authorService.getAuthorById(bookModel.getAuthor().getId())
            );
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    public Boolean bookExists(UUID id) {
        return bookRepository.existsById(id);
    }

    public BookDto addBook(BookDto bookDto) {
        var bookModel = new BookModel();
        BeanUtils.copyProperties(bookDto, bookModel);
        var newBookModel = bookRepository.save(bookModel);
        return new BookDto(
                newBookModel.getName(),
                newBookModel.getPages(),
                newBookModel.getDateTimeReleased(),
                newBookModel.getDateTimeCreated(),
                newBookModel.getDateTimeModified(),
                null);
    }

    public BookDto updateBook(UUID id, BookDto bookDto) {
        var bookModel = bookRepository.findById(id).get();
        BeanUtils.copyProperties(bookDto, bookModel);
        bookRepository.save(bookModel);
        return new BookDto(
                bookModel.getName(),
                bookModel.getPages(),
                bookModel.getDateTimeReleased(),
                bookModel.getDateTimeCreated(),
                bookModel.getDateTimeModified(),
                authorService.getAuthorById(bookModel.getAuthor().getId())
        );
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
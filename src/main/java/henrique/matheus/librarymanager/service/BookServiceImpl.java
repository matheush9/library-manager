package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.BookRequestDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.dtos.BookSimpleDTO;
import henrique.matheus.librarymanager.mappers.BookMapper;
import henrique.matheus.librarymanager.model.BookModel;
import henrique.matheus.librarymanager.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookResponseDto getBookById(UUID id) {
        var bookModel = bookRepository.findById(id).get();
        return bookMapper.bookModelToBookRepDto(bookModel);
    }

    @Override
    public List<BookSimpleDTO> getAllBooks() {
        var bookModels = bookRepository.findAll();
        List<BookSimpleDTO> bookDtos = new ArrayList<>();
        for (BookModel bookModel: bookModels) {
            var bookDto = bookMapper.bookModelToBookSimpleDto(bookModel);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public Boolean bookExists(UUID id) {
        return bookRepository.existsById(id);
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        var bookModel = new BookModel();
        bookModel.setDateTimeCreated(ZonedDateTime.now());
        bookModel.setDateTimeModified(ZonedDateTime.now());
        BeanUtils.copyProperties(bookRequestDto, bookModel);
        var newBookModel = bookRepository.save(bookModel);
        return bookMapper.bookModelToBookRepDto(newBookModel);
    }

    @Override
    public BookResponseDto updateBook(UUID id, BookRequestDto bookRequestDto) {
        var bookModel = bookRepository.findById(id).get();
        bookModel.setDateTimeModified(ZonedDateTime.now());
        BeanUtils.copyProperties(bookRequestDto, bookModel);
        bookRepository.save(bookModel);
        return bookMapper.bookModelToBookRepDto(bookModel);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
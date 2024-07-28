package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.BookDto;

import java.util.List;
import java.util.UUID;

public interface BookService {
    public BookDto getBookById(UUID id);
    public List<BookDto> getAllBooks();
    public Boolean bookExists(UUID id);
    public BookDto addBook(BookDto bookDto);
    public BookDto updateBook(UUID id, BookDto bookDto);
    public void deleteBook(UUID id);
}

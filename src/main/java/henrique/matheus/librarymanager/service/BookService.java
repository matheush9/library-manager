package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.BookRequestDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.dtos.BookSimpleDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {
    public BookResponseDto getBookById(UUID id);
    public List<BookSimpleDTO> getAllBooks();
    public Boolean bookExists(UUID id);
    public BookResponseDto addBook(BookRequestDto bookRequestDto);
    public BookResponseDto updateBook(UUID id, BookRequestDto bookRequestDto);
    public void deleteBook(UUID id);
}

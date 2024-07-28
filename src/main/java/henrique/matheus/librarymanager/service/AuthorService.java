package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.AuthorRequestDto;
import henrique.matheus.librarymanager.dtos.AuthorResponseDto;
import henrique.matheus.librarymanager.dtos.AuthorSimpleDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public AuthorResponseDto getAuthorById(UUID id);
    public List<AuthorSimpleDto> getAllAuthors();
    public Boolean authorExists(UUID id);
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    public AuthorResponseDto updateAuthor(UUID id, AuthorRequestDto authorRequestDto);
    public void deleteAuthor(UUID id);
}

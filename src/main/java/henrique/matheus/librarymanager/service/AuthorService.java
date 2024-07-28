package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.AuthorDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public AuthorDto getAuthorById(UUID id);
    public List<AuthorDto> getAllAuthors();
    public Boolean authorExists(UUID id);
    public AuthorDto addAuthor(AuthorDto authorDto);
    public AuthorDto updateAuthor(UUID id, AuthorDto authorDto);
    public void deleteAuthor(UUID id);
}

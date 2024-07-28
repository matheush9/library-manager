package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.AuthorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AuthorController {
    public ResponseEntity<Object> getAuthor(UUID id);
    public ResponseEntity<List<AuthorDto>> getAllAuthors();
    public ResponseEntity<AuthorDto> addAuthor(AuthorDto authorDto);
    public ResponseEntity<Object> updateAuthor(UUID id, AuthorDto authorDto);
    public ResponseEntity<Object> deleteAuthor(UUID id);
}

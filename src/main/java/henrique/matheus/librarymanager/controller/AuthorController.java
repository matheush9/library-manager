package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.AuthorRequestDto;
import henrique.matheus.librarymanager.dtos.AuthorResponseDto;
import henrique.matheus.librarymanager.dtos.AuthorSimpleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AuthorController {
    public ResponseEntity<Object> getAuthor(UUID id);
    public ResponseEntity<List<AuthorSimpleDto>> getAllAuthors();
    public ResponseEntity<AuthorResponseDto> addAuthor(AuthorRequestDto authorRequestDto);
    public ResponseEntity<Object> updateAuthor(UUID id, AuthorRequestDto authorRequestDto);
    public ResponseEntity<Object> deleteAuthor(UUID id);
}

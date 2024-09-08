package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.dtos.AuthorRequestDto;
import henrique.matheus.librarymanager.dtos.AuthorResponseDto;
import henrique.matheus.librarymanager.dtos.AuthorSimpleDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AuthorControllerImpl implements AuthorController {

    @Autowired
    private AuthorService authorService;

    @Override
    @GetMapping("/authors/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable(value="id") UUID id) {
        var authorExists = authorService.authorExists(id);
        if (!authorExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        var authorDto = authorService.getAuthorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(authorDto);
    }

    @Override
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorSimpleDto>> getAllAuthors() {
        var authorList = authorService.getAllAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(authorList);
    }

    @Override
    @PostMapping("/authors")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(authorRequestDto));
    }

    @Override
    @PutMapping("/authors/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable(value="id") UUID id,
                                               @RequestBody AuthorRequestDto authorRequestDto) {
        var authorExists = authorService.authorExists(id);
        if (!authorExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorService.updateAuthor(id, authorRequestDto));
    }

    @Override
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable(value="id") UUID id) {
        var authorExists = authorService.authorExists(id);
        if (!authorExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        authorService.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Author deleted successfully!");
    }
}

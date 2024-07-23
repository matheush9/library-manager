package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.AuthorModel;
import henrique.matheus.librarymanager.service.AuthorService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping("/authors/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable(value="id") UUID id) {
        var authorExists = authorService.authorExists(id);
        if (!authorExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        var authorModel = authorService.getAuthorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(authorModel);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {
        var authorList = authorService.getAllAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(authorList);
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorModel> addAuthor(@RequestBody AuthorModel authorModel) {
        var newAuthorModel = new AuthorModel();
        BeanUtils.copyProperties(authorModel, newAuthorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(newAuthorModel));
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable(value="id") UUID id,
                                               @RequestBody AuthorModel authorModel) {
        var authorExists = authorService.authorExists(id);
        if (!authorExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorService.updateAuthor(id, authorModel));
    }

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

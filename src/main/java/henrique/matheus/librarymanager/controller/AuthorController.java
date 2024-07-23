package henrique.matheus.librarymanager.controller;

import henrique.matheus.librarymanager.model.AuthorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AuthorController {
    public ResponseEntity<Object> getAuthor(UUID id);
    public ResponseEntity<List<AuthorModel>> getAllAuthors();
    public ResponseEntity<AuthorModel> addAuthor(AuthorModel authorModel);
    public ResponseEntity<Object> updateAuthor(UUID id, AuthorModel authorModel);
    public ResponseEntity<Object> deleteAuthor(UUID id);
}

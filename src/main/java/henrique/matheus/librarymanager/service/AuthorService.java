package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.AuthorModel;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public AuthorModel getAuthorById(UUID id);
    public List<AuthorModel> getAllAuthors();
    public Boolean authorExists(UUID id);
    public AuthorModel addAuthor(AuthorModel authorModel);
    public AuthorModel updateAuthor(UUID id, AuthorModel authorModel);
    public void deleteAuthor(UUID id);
}

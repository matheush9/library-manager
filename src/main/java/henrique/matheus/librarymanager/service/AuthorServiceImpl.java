package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.model.AuthorModel;
import henrique.matheus.librarymanager.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorModel getAuthorById(UUID id) {
        return authorRepository.findById(id).get();
    }

    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Boolean authorExists(UUID id) {
        return authorRepository.existsById(id);
    }

    public AuthorModel addAuthor(AuthorModel authorModel) {
        return authorRepository.save(authorModel);
    }

    public AuthorModel updateAuthor(UUID id, AuthorModel authorModel) {
        var newBook = getAuthorById(id);
        BeanUtils.copyProperties(authorModel, newBook, "id");
        return authorRepository.save(newBook);
    }

    public void deleteAuthor(UUID id) {
        authorRepository.deleteById(id);
    }
}

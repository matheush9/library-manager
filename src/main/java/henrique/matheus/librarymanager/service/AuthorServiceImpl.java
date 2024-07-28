package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.AuthorDto;
import henrique.matheus.librarymanager.model.AuthorModel;
import henrique.matheus.librarymanager.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto getAuthorById(UUID id) {
        var authorModel = authorRepository.findById(id).get();
        return new AuthorDto(
            authorModel.getName(),
            authorModel.getAge(),
            authorModel.getCountry(),
            authorModel.getDateTimeCreated(),
            authorModel.getDateTimeModified(),
            authorModel.getBooks());
    }

    public List<AuthorDto> getAllAuthors() {
        var authorModels = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (AuthorModel authorModel: authorModels) {
            AuthorDto authorDto = new AuthorDto(
                                    authorModel.getName(),
                                    authorModel.getAge(),
                                    authorModel.getCountry(),
                                    authorModel.getDateTimeCreated(),
                                    authorModel.getDateTimeModified(),
                                    authorModel.getBooks()
            );
            authorDtos.add(authorDto);
        }
        return authorDtos;
    }

    public Boolean authorExists(UUID id) {
        return authorRepository.existsById(id);
    }

    public AuthorDto addAuthor(AuthorDto authorDto) {
        var authorModel = new AuthorModel();
        BeanUtils.copyProperties(authorDto, authorModel);
        var newAuthorModel = authorRepository.save(authorModel);
        return new AuthorDto(
                newAuthorModel.getName(),
                newAuthorModel.getAge(),
                newAuthorModel.getCountry(),
                newAuthorModel.getDateTimeCreated(),
                newAuthorModel.getDateTimeModified(),
                newAuthorModel.getBooks());
    }

    public AuthorDto updateAuthor(UUID id, AuthorDto authorDto) {
        var authorModel = authorRepository.findById(id).get();
        BeanUtils.copyProperties(authorDto, authorModel);
        authorRepository.save(authorModel);
        return new AuthorDto(
                authorModel.getName(),
                authorModel.getAge(),
                authorModel.getCountry(),
                authorModel.getDateTimeCreated(),
                authorModel.getDateTimeModified(),
                authorModel.getBooks());
    }

    public void deleteAuthor(UUID id) {
        authorRepository.deleteById(id);
    }
}

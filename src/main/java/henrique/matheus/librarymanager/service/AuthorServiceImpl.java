package henrique.matheus.librarymanager.service;

import henrique.matheus.librarymanager.dtos.AuthorRequestDto;
import henrique.matheus.librarymanager.dtos.AuthorResponseDto;
import henrique.matheus.librarymanager.dtos.AuthorSimpleDto;
import henrique.matheus.librarymanager.mappers.AuthorMapper;
import henrique.matheus.librarymanager.model.AuthorModel;
import henrique.matheus.librarymanager.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorResponseDto getAuthorById(UUID id) {
        var authorModel = authorRepository.findById(id).get();
        return authorMapper.authorModelToAuthorRepDto(authorModel);
    }

    @Override
    public List<AuthorSimpleDto> getAllAuthors() {
        var authorModels = authorRepository.findAll();
        List<AuthorSimpleDto> authorRequestDtos = new ArrayList<>();
        for (AuthorModel authorModel: authorModels) {
            var authorDto = authorMapper.authorModelToAuthorSimpleDto(authorModel);
            authorRequestDtos.add(authorDto);
        }
        return authorRequestDtos;
    }

    @Override
    public Boolean authorExists(UUID id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        var authorModel = new AuthorModel();
        authorModel.setDateTimeCreated(ZonedDateTime.now());
        authorModel.setDateTimeModified(ZonedDateTime.now());
        BeanUtils.copyProperties(authorRequestDto, authorModel);
        var newAuthorModel = authorRepository.save(authorModel);
        return authorMapper.authorModelToAuthorRepDto(newAuthorModel);
    }

    @Override
    public AuthorResponseDto updateAuthor(UUID id, AuthorRequestDto authorRequestDto) {
        var authorModel = authorRepository.findById(id).get();
        authorModel.setDateTimeModified(ZonedDateTime.now());
        BeanUtils.copyProperties(authorRequestDto, authorModel);
        authorRepository.save(authorModel);
        return authorMapper.authorModelToAuthorRepDto(authorModel);
    }

    @Override
    public void deleteAuthor(UUID id) {
        authorRepository.deleteById(id);
    }
}

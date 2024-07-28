package henrique.matheus.librarymanager.mappers;

import henrique.matheus.librarymanager.dtos.AuthorResponseDto;
import henrique.matheus.librarymanager.dtos.AuthorSimpleDto;
import henrique.matheus.librarymanager.model.AuthorModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorSimpleDto authorModelToAuthorSimpleDto(AuthorModel authorModel);
    AuthorResponseDto authorModelToAuthorRepDto(AuthorModel authorModel);
}

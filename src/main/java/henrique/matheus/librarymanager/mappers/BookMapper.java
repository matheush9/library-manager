package henrique.matheus.librarymanager.mappers;

import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.dtos.BookSimpleDTO;
import henrique.matheus.librarymanager.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "dateTimeModified", target = "dateTimeChanged")
    BookResponseDto bookModelToBookRepDto(BookModel bookModel);
    @Mapping(source = "dateTimeModified", target = "dateTimeChanged")
    BookSimpleDTO bookModelToBookSimpleDto(BookModel bookModel);
}

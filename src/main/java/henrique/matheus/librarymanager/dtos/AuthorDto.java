package henrique.matheus.librarymanager.dtos;

import henrique.matheus.librarymanager.model.BookModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.ZonedDateTime;
import java.util.Set;

public record AuthorDto(@NotBlank String name,
                        @Positive int age,
                        String country,
                        ZonedDateTime dateTimeCreated,
                        ZonedDateTime dateTimeModified,
                        Set<BookModel> books) {
}

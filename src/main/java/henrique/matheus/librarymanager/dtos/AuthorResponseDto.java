package henrique.matheus.librarymanager.dtos;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

public record AuthorResponseDto(UUID id,
                                String name,
                                int age,
                                String country,
                                ZonedDateTime dateTimeCreated,
                                ZonedDateTime dateTimeModified,
                                Set<BookSimpleDTO> books) {
}

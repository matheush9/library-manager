package henrique.matheus.librarymanager.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

public record AuthorSimpleDto(UUID id,
                              String name,
                              int age,
                              String country,
                              ZonedDateTime dateTimeCreated,
                              ZonedDateTime dateTimeModified) {
}

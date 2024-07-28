package henrique.matheus.librarymanager.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

public record BookResponseDto(UUID id,
                              String name,
                              int pages,
                              ZonedDateTime dateTimeReleased,
                              ZonedDateTime dateTimeCreated,
                              ZonedDateTime dateTimeChanged,
                              AuthorRequestDto author) {
}

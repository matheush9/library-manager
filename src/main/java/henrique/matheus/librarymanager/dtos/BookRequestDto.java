package henrique.matheus.librarymanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.ZonedDateTime;

public record BookRequestDto(@NotBlank String name,
                             @Positive int pages,
                             ZonedDateTime dateTimeReleased) {
}

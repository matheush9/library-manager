package henrique.matheus.librarymanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AuthorRequestDto(@NotBlank String name,
                               @Positive int age,
                               String country) {
}

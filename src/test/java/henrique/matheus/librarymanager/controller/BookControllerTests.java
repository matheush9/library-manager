package henrique.matheus.librarymanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import henrique.matheus.librarymanager.dtos.BookRequestDto;
import henrique.matheus.librarymanager.dtos.BookResponseDto;
import henrique.matheus.librarymanager.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = BookControllerImpl.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateBook() throws Exception {
        //Arrange
        BookRequestDto bookDto = new BookRequestDto(
                "A book",
                42,
                ZonedDateTime.now());

        BookResponseDto bookResponseDto = new BookResponseDto(
                UUID.randomUUID(),
                bookDto.name(),
                bookDto.pages(),
                bookDto.dateTimeReleased(),
                ZonedDateTime.now(),
                ZonedDateTime.now(),
                null
        );

        //Act
        BDDMockito.given(bookService.addBook(ArgumentMatchers.any()))
                .willReturn(bookResponseDto);

        ResultActions response = mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDto)));

        //Assert
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}

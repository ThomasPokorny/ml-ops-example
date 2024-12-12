package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    BookMapper bookMapper;

    @InjectMocks
    BookService bookService;

    @Test
    void Should_SaveBook() {
        final var createBook = BookCreateUpdateDto.builder()
                .title("Book Title")
                .isbn("1234")
                .author("John Doe").build();
        when(bookMapper.toEntity(any())).thenReturn(new Book().toBuilder()
                .title(createBook.title())
                .isbn(createBook.isbn())
                .author(createBook.author()).build());

        bookService.createBook(createBook);
        verify(bookRepository).save(argThat(book -> book.getIsbn().equals(createBook.isbn())));
    }
}

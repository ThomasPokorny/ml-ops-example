package com.tp.domain.book;

import com.tp.domain.book.dto.BookCreateUpdateDto;
import com.tp.domain.book.dto.BookDto;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-12T16:26:25+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookCreateUpdateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.title( dto.title() );
        book.author( dto.author() );
        book.isbn( dto.isbn() );

        return book.build();
    }

    @Override
    public void updateEntity(Book book, BookCreateUpdateDto dto) {
        if ( dto == null ) {
            return;
        }

        book.setTitle( dto.title() );
        book.setAuthor( dto.author() );
        book.setIsbn( dto.isbn() );
    }

    @Override
    public BookDto toDto(Book entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String title = null;
        String author = null;
        String isbn = null;

        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        isbn = entity.getIsbn();

        BookDto bookDto = new BookDto( id, title, author, isbn );

        return bookDto;
    }
}

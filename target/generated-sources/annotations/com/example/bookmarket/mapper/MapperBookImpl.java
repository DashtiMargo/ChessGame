package com.example.bookmarket.mapper;

import com.example.bookmarket.dto.BookDtoRequest;
import com.example.bookmarket.dto.BookDtoResponse;
import com.example.bookmarket.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-19T15:28:56+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class MapperBookImpl implements MapperBook {

    @Override
    public BookDtoResponse toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoResponse bookDtoResponse = new BookDtoResponse();

        bookDtoResponse.setId( book.getId() );
        bookDtoResponse.setTitle( book.getTitle() );
        bookDtoResponse.setAuthor( book.getAuthor() );

        return bookDtoResponse;
    }

    @Override
    public Book toEntity(BookDtoRequest bookDtoRequest) {
        if ( bookDtoRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookDtoRequest.getTitle() );
        book.setAuthor( bookDtoRequest.getAuthor() );

        return book;
    }
}

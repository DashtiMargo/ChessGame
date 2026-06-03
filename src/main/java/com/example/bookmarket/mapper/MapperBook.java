package com.example.bookmarket.mapper;

import com.example.bookmarket.dto.BookDtoRequest;
import com.example.bookmarket.dto.BookDtoResponse;
import com.example.bookmarket.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperBook {
    BookDtoResponse toDto(Book book);
    Book toEntity(BookDtoRequest bookDtoRequest);
}


package com.example.bookmarket.controller;

import com.example.bookmarket.dto.BookDtoRequest;
import com.example.bookmarket.dto.BookDtoResponse;
import com.example.bookmarket.entity.Book;
import com.example.bookmarket.mapper.MapperBook;
import com.example.bookmarket.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final MapperBook mapper;

    @PostMapping("/save")
    public ResponseEntity<BookDtoResponse> save(@RequestBody BookDtoRequest bookDtoRequest) {
        Book saved = bookService.save(mapper.toEntity(bookDtoRequest));
        return ResponseEntity.ok(mapper.toDto(saved));
    }
}
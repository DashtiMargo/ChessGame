package com.example.bookmarket.service;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Note with id %d not found".formatted(id));
    }
}


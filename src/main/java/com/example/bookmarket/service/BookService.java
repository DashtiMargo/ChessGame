package com.example.bookmarket.service;

import com.example.bookmarket.entity.Book;
import com.example.bookmarket.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    @Transactional
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Transactional(readOnly = true)
    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    @Transactional
    public Book update(int id, Book bookUpdate) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitle(bookUpdate.getTitle());
        book.setAuthor(bookUpdate.getAuthor());

        return bookRepo.save(book);
    }

    @Transactional
    public void delete(int id) {
        bookRepo.deleteById(id);
    }
}

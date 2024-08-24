package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import java.awt.print.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        // Logic to update the book
        return bookDetails;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        // Logic to delete the book
    }
}

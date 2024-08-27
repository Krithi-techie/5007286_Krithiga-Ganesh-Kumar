package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.model.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        bookList.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with ID " + id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable Long id) {
        Book book = bookList.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException("Book not found with ID " + id));

        EntityModel<Book> resource = EntityModel.of(book);
        Link selfLink = WebMvcLinkBuilder.linkTo(BookController.class).slash(book.getId()).withSelfRel();
        resource.add(selfLink);
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        return bookList.stream()
            .filter(book -> (title == null || book.getTitle().contains(title)) &&
                            (author == null || book.getAuthor().contains(author)))
            .collect(Collectors.toList());
    }
}

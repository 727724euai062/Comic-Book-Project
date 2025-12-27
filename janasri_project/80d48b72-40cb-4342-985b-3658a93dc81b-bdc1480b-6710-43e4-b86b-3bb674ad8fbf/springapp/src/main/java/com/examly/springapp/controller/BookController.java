package com.examly.springapp.controller;

import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book saved = service.add(book);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {

        Book updated = service.update(id, book);
        return ResponseEntity.ok(updated);
    }

    // SEARCH BY TITLE
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        List<Book> list = service.getByTitle(title);
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No book found with title: " + title);
        }
        return ResponseEntity.ok(list);
    }

    // SEARCH BY CATEGORY NAME
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Book>> getByCategory(
            @PathVariable String categoryName) {

        return ResponseEntity.ok(service.getByCategory(categoryName));
    }
}

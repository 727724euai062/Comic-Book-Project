package com.examly.springapp.controller;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService service;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody(required = false) BookCategory bookCategory) {
        if (bookCategory == null) {
            return ResponseEntity.badRequest().build();
        }
        BookCategory saved = service.add(bookCategory);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<BookCategory> list = service.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Optional<BookCategory> category = service.getById(id);
        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book category not found");
        }
        return ResponseEntity.ok(category.get());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody BookCategory bookCategory) {

        BookCategory updated = service.update(id, bookCategory);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // PAGINATION + SORTING
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<BookCategory>> paginate(
            @PathVariable int page,
            @PathVariable int size) {

        Page<BookCategory> result = service.paginate(page, size);
        return ResponseEntity.ok(result);
    }
}

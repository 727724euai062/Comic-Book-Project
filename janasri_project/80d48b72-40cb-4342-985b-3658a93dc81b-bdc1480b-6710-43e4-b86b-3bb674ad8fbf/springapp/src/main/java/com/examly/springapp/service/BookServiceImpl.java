package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import com.examly.springapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book add(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public Book update(Long id, Book book) {
        book.setBookId(id);
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    @Override
    public List<Book> getByCategory(String categoryName) {
        return bookRepo.findByBookCategory_CategoryName(categoryName);
    }
}

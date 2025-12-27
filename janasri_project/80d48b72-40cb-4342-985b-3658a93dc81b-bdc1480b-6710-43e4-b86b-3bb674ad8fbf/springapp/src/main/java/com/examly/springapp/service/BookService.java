package com.examly.springapp.service;

import com.examly.springapp.model.Book;

import java.util.List;

public interface BookService {

    Book add(Book book);

    List<Book> getAll();

    Book getById(Long id);

    Book update(Long id, Book book);

    List<Book> getByTitle(String title);

    List<Book> getByCategory(String categoryName);
}

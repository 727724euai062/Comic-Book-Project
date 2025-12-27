package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import com.examly.springapp.model.BookCategory;
public interface BookCategoryService {
    BookCategory add(BookCategory bc);
    List<BookCategory> getAll();
    Optional<BookCategory> getById(Long id);
    BookCategory update(Long id, BookCategory bc);
    void delete(Long id);
    Page<BookCategory> paginate(int page, int size);
}

package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    @Override
    public BookCategory add(BookCategory bookCategory) {
        return bookCategoryRepo.save(bookCategory);
    }

    @Override
    public List<BookCategory> getAll() {
        return bookCategoryRepo.findAll();
    }

    @Override
    public Optional<BookCategory> getById(Long id) {
        return bookCategoryRepo.findById(id);
    }

    @Override
    public BookCategory update(Long id, BookCategory bookCategory) {
        bookCategory.setCategoryId(id);
        return bookCategoryRepo.save(bookCategory);
    }

    @Override
    public void delete(Long id) {
        bookCategoryRepo.deleteById(id);
    }

    @Override
    public Page<BookCategory> paginate(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId"));
        return bookCategoryRepo.findAll(pageable);
    }
}


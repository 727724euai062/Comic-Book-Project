package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.repository.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Override
    public Borrow add(Borrow borrow) {
        return borrowRepo.save(borrow);
    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepo.findAll();
    }
}

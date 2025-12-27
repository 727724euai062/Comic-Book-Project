package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;

import java.util.List;

public interface BorrowService {

    Borrow add(Borrow borrow);

    List<Borrow> getAll();
}

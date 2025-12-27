package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowId;

    public Integer getBorrowId() { return borrowId; }
    public void setBorrowId(Integer borrowId) { this.borrowId = borrowId; }
}

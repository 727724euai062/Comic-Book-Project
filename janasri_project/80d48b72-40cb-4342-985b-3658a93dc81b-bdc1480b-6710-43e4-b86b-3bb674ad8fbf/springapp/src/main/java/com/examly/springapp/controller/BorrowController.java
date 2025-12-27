package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @GetMapping("/{id}")
    public void getBorrowById(@PathVariable int id) {
    }
}

package com.examly.springapp.service;

import com.examly.springapp.model.Fine;

import java.util.List;

public interface FineService {

    Fine add(Fine fine);

    List<Fine> getAll();
}

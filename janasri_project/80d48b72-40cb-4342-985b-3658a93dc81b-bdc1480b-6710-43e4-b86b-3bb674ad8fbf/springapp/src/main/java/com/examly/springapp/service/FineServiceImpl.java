package com.examly.springapp.service;

import com.examly.springapp.model.Fine;
import com.examly.springapp.repository.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineServiceImpl implements FineService {

    @Autowired
    private FineRepo fineRepo;

    @Override
    public Fine add(Fine fine) {
        return fineRepo.save(fine);
    }

    @Override
    public List<Fine> getAll() {
        return fineRepo.findAll();
    }
}

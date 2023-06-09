package com.ftn.service.services;

import java.util.List;

import com.ftn.model.Fragrance;
import com.ftn.service.repository.FragranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FragranceService {
    @Autowired
    FragranceRepository fragranceRepository;

    public List<Fragrance> findAll() {
        return fragranceRepository.findAll();
    }
}

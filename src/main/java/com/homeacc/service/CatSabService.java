package com.homeacc.service;

import com.homeacc.repository.CatSabRepository;
import org.springframework.stereotype.Service;

@Service
public class CatSabService {
    private final CatSabRepository catSabRepository;

    public CatSabService(CatSabRepository catSabRepository) {
        this.catSabRepository = catSabRepository;
    }
}

package com.homeacc.service;

import com.homeacc.repository.CatSab;
import com.homeacc.repository.CatSabRepository;
import com.homeacc.repository.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatSabService {

    private final CatSabRepository catSabRepository;

    public CatSabService(CatSabRepository catSabRepository) {
        this.catSabRepository = catSabRepository;
    }

    public List<CatSab> getAllCategory(String user_login){
        return catSabRepository.findAllByUserLogin(user_login);
    }
}

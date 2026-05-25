package com.homeacc.service;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final TransactionsRepository transactionsRepository;
    public HomeService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }
    public List<Transactions> getAllTransactions(String user_login){
        return transactionsRepository.findALLByUserLogin(user_login);
    }
}

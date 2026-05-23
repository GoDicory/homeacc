package com.homeacc.service;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;
    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public Transactions add(Transactions transactions){

        return transactionsRepository.save(transactions);
    }

    public List<Transactions> getAllTransactions(String user_login){
        return transactionsRepository.findALLByUserLogin(user_login);
    }

    public  void deleteByID(Long id) {
        transactionsRepository.deleteById(id);
    }
}

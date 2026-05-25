package com.homeacc.service;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.TransactionsRepository;
import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final UserRepository userRepository;

    public TransactionsService(TransactionsRepository transactionsRepository, UserRepository userRepository) {
        this.transactionsRepository = transactionsRepository;
        this.userRepository = userRepository;
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

    public void setBalanceUser(String userLogin){
        User user = userRepository.findByLogin(userLogin);
        user.setBalance(transactionsRepository.sumUserTransactions(userLogin));
        userRepository.save(user);
    }






}

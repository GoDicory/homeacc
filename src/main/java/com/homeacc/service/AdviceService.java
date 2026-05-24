package com.homeacc.service;

import com.homeacc.repository.TransactionsRepository;
import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class AdviceService {
    private final UserRepository userRepository;
    private final TransactionsRepository transactionsRepository;

    public AdviceService(UserRepository userRepository, TransactionsRepository transactionsRepository) {
        this.userRepository = userRepository;
        this.transactionsRepository = transactionsRepository;
    }
    public String getLoginUser(Long userId){
        return userRepository.findById(userId).orElse(new User()).getLogin();
    }



}

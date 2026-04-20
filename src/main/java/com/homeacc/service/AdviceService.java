package com.homeacc.service;

import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class AdviceService {
    private final UserRepository userRepository;

    public AdviceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public BigDecimal getBalanceUser(Long userId){
        return userRepository.findById(userId).orElse(new User()).getBalance();
    }
    public String getLoginUser(Long userId){
        return userRepository.findById(userId).orElse(new User()).getLogin();
    }
}

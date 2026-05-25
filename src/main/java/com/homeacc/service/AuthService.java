package com.homeacc.service;

import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user){
        user.setBalance(BigDecimal.ZERO);
        return userRepository.save(user);
    }

    public User autorizations(String login, String password){
        User user = userRepository.findByLogin(login);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}

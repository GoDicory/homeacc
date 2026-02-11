package com.homeacc.service;

import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    private final UserRepository userRepository;

    public MainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> testBD(){
        return userRepository.findAll();
    }

    public int testService(){
        int a = 5;
        int b = 10;
        int c = a + b;
        return c;



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

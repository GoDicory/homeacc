package com.homeacc.service;

import com.homeacc.repository.User;
import com.homeacc.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()){
            throw new IllegalStateException("юзер с таким мылом уже есть");
        }
        return userRepository.save(user);
    }
}

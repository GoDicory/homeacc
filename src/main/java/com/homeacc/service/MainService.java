package com.homeacc.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    public int testService(){
        int a = 5;
        int b = 10;
        int c = a + b;
        return c;
    }
}

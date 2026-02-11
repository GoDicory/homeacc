package com.homeacc.controller;


import com.homeacc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping(path = "/user/")
public class indexController {

    @Autowired
    private MainService mainService;

    @GetMapping
    public String index(Model model){
        return "index";
    }
}

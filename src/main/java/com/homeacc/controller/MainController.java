package com.homeacc.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String mainTest(Model model){
        model.addAttribute("username", "Джун Программер");
        return "mainTest";
    }
}

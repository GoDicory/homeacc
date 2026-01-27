package com.homeacc.controller;

import com.homeacc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping
    public String mainTest(Model model){
        model.addAttribute("username", "Джун Программер 27.01.2026");
        model.addAttribute("serviceTest", mainService.testService());
        return "mainTest";
    }
}

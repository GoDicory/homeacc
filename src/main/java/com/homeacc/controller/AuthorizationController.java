package com.homeacc.controller;

import com.homeacc.repository.User;
import com.homeacc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class AuthorizationController {

    @Autowired
    private MainService mainService;


    @GetMapping
    public String mainTest(Model model){

        model.addAttribute("username", "Джун Программер 27.01.2026");
        model.addAttribute("serviceTest", mainService.testService());
        model.addAttribute("bazaAll", mainService.testBD());
        model.addAttribute("user", new User());
        //model.addAttribute("userLogin", mainService.);
        return "authorization";
    }

    @PostMapping()
    public String create(@ModelAttribute User user, Model model){
        mainService.create(user);
        return "redirect:/";
    }

    @PostMapping("/login/")
    public String authorizationUser(String login, String password){
        if(mainService.autorizations(login,password) != null){
            return "redirect:/user/";
        } else {
            return "redirect:/";
        }

    }
}

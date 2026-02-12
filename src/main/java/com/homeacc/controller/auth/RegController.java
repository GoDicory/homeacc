package com.homeacc.controller.auth;

import com.homeacc.repository.User;
import com.homeacc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping(path = "/auth/reg-user/")
public class RegController {

    @Autowired
    private AuthService authService;


    @GetMapping
    public  String registration(Model model){
        model.addAttribute("user", new User());
        return "auth/reg-user";
    }

    @PostMapping
    public String create(@ModelAttribute User user, Model model){
        authService.create(user);
        return "redirect:/";
    }
}

package com.homeacc.controller;

import com.homeacc.repository.User;
import com.homeacc.service.MainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping(path = "/users/")
public class indexController {

    @Autowired
    private MainService mainService;

    @GetMapping
    public String index(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");

        if(currentUser != null){
            return "index";
        } else {
            return "redirect:/";
        }
    }
}

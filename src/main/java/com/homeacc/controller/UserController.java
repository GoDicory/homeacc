package com.homeacc.controller;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.TransactionsRepository;
import com.homeacc.repository.User;
import com.homeacc.service.AuthService;
import com.homeacc.service.HomeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path = "/auth/home/")
public class UserController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public String index(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser != null){
            List<Transactions> transactions = homeService.getAllTransactions(currentUser.getLogin());
            model.addAttribute("user",currentUser);
            model.addAttribute("transactions", transactions);
            return "home";
        } else {
            return "redirect:/";
        }
    }
}

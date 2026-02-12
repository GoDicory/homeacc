package com.homeacc.controller.auth;

import com.homeacc.repository.User;
import com.homeacc.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String login(Model model){
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/auth/login/")
    public String authorizationUser(String login, String password, HttpSession session){
        User user = authService.autorizations(login,password);
        if(user != null){
            session.setAttribute("currentUser", user);
            return "redirect:/auth/user/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }







}

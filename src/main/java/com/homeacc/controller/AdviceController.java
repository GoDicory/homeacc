package com.homeacc.controller;

import com.homeacc.repository.User;
import com.homeacc.service.AdviceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@ControllerAdvice
public class AdviceController {

    @Autowired
    private final AdviceService adviceService;

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @ModelAttribute("userBalance")
    public BigDecimal getUserBalance(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null){
            return adviceService.getBalanceUser(currentUser.getId());
        }
        return BigDecimal.ZERO;
    }

    @ModelAttribute("userLogin")
    public String getUserLogin(HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null){
            return adviceService.getLoginUser(currentUser.getId());
        }
        return "Гость";


    }
}

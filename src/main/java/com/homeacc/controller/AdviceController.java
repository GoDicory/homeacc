package com.homeacc.controller;

import com.homeacc.repository.Transactions;
import com.homeacc.repository.TransactionsRepository;
import com.homeacc.repository.User;
import com.homeacc.service.AdviceService;
import com.homeacc.service.TransactionsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@ControllerAdvice
public class AdviceController {

    @Autowired
    AdviceService adviceService;
    @Autowired
    TransactionsService transactionsService;
    @Autowired
    TransactionsRepository transactionsRepository;


    @ModelAttribute("userBalance")
    public BigDecimal getUserBalance(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null){
            transactionsService.setBalanceUser(currentUser.getLogin());
            return transactionsRepository.sumUserTransactions(currentUser.getLogin());
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

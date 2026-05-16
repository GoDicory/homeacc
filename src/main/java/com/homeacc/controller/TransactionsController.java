package com.homeacc.controller;

import com.homeacc.repository.CatSab;
import com.homeacc.repository.Transactions;
import com.homeacc.repository.User;
import com.homeacc.service.AdviceService;
import com.homeacc.service.CatSabService;
import com.homeacc.service.TransactionsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/auth/transactions/")
public class TransactionsController {

    @Autowired
    private final AdviceService adviceService;
    @Autowired
    private final TransactionsService transactionsService;

    @Autowired
    private final CatSabService catSabService;

    public TransactionsController(AdviceService adviceService, TransactionsService transactionsService, CatSabService catSabService) {
        this.adviceService = adviceService;
        this.transactionsService = transactionsService;
        this.catSabService = catSabService;
    }

    @GetMapping
    public String index(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser != null){
            List<Transactions> tablesTransactions = transactionsService.getAllTransactions(currentUser.getLogin());
            model.addAttribute("tablesTransactions", tablesTransactions);
            model.addAttribute("user",currentUser);
            model.addAttribute("transactions", new Transactions()).addAttribute("category", new CatSab());
            return "transactions";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping
    public String add(@ModelAttribute Transactions transactions, Model model,HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        String userLogin = adviceService.getLoginUser(currentUser.getId());
        transactions.setUserLogin(userLogin);
//        transactions.setCategories("Транзакт контроллер");
        transactionsService.add(transactions);
        return "redirect:/auth/transactions/";
    }
}

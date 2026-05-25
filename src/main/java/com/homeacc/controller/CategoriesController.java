package com.homeacc.controller;

import com.homeacc.repository.CatSab;
import com.homeacc.repository.Transactions;
import com.homeacc.repository.User;
import com.homeacc.service.AdviceService;
import com.homeacc.service.AuthService;
import com.homeacc.service.CatSabService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/auth/categories/")
public class CategoriesController {
    @Autowired
    private CatSabService catSabService;
    @Autowired
    private AdviceService adviceService;
    @GetMapping
    public String index(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser != null){
            List<CatSab> catBlockAll = catSabService.getAllCategory(currentUser.getLogin());
            model.addAttribute("user",currentUser);
            model.addAttribute("catBlockAll", catBlockAll);
            model.addAttribute("newCatSab", new CatSab());
            return "categories";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        catSabService.deleteByID(id);
        return "redirect:/auth/categories/";
    }
    @PostMapping
    public String add(@ModelAttribute CatSab catSab, Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        String userLogin = adviceService.getLoginUser(currentUser.getId());
        catSab.setUserLogin(userLogin);
        catSabService.add(catSab);
        return "redirect:/auth/categories/";
    }
}

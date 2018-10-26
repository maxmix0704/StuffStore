package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String getMainPage(Model model){
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
//    @RequestMapping("/logout")
//    public String getLogout(){
//        return "redirect:/";
//    }

}

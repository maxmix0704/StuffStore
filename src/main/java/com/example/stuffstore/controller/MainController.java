package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String getMainPage(){
        return "home";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String doLogin(){
        return "main";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam String discription,Model model){
        Product product = new Product(name,discription);
        productRepo.save(product);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "main";
    }

    @GetMapping("/main")
    public String getMain(Model model){
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "main";
    }

    @RequestMapping("/logout")
    public String getLogout(){
        return "main";
    }

}

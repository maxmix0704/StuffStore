package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.CategoryRepo;
import com.example.stuffstore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String getMainPage(Model model){
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(Model model){
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories",categories);
        return "adminPage";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

}

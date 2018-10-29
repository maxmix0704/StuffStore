package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.CategoryRepo;
import com.example.stuffstore.repository.ProductRepo;
import com.example.stuffstore.services.CategoryService;
import com.example.stuffstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String getMainPage(Model model){
        Iterable<Product> products = productService.getAll();
        Iterable<Category> categories = categoryService.getAll();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        return "home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(Model model){
        Iterable<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "adminPage";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/filter")
    public String getProductFilter(
            @RequestParam String filter,
            Model model
    ){
        if (!filter.isEmpty()) {
            Iterable<Product> products = productService.getProductsByCategory(filter);
            long size = products.spliterator().getExactSizeIfKnown();
            if (size == 0) model.addAttribute("message", "Not found");
            model.addAttribute("products", products);
            Iterable<Category> categories = categoryService.getAll();
            model.addAttribute("categories",categories);
            return "home";
        }
        else
            return "redirect:/";
    }

}

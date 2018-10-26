package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.entity.Product;
import com.example.stuffstore.entity.Role;
import com.example.stuffstore.entity.User;
import com.example.stuffstore.repository.CategoryRepo;
import com.example.stuffstore.repository.ProductRepo;
import com.example.stuffstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductRepo productRepo;


    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("userList",userRepo.findAll());
        return "userList";
    }

    @GetMapping
    public String getAdminPage(Model model){
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories",categories);
        return "adminPage";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String discription,
                             @RequestParam String category_id,
                             @RequestParam Float price,
                             @RequestParam("file") MultipartFile file,
                             Model model) throws IOException
    {
        Category category = categoryRepo.findById(Long.valueOf(category_id)).get();
        Product product = new Product(name,discription);
        product.setPrice(price);
        product.setCategory(category);
        if (file!=null&&!file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath+"/"+resultFilename));
            product.setFilename(resultFilename);
        }
        productRepo.save(product);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "redirect:/admin";
    }


    @GetMapping("/userList/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "userEdits";
    }
    @PostMapping("/userList")
    public String userSave(
            @RequestParam("userName") String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        user.setUsername(username);
        userRepo.save(user);
        return "redirect:/admin/userList";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String categoryName,
                              Model model) throws IOException
    {
        Category category = new Category();
        if (!categoryName.isEmpty()) {
            category.setCategory(categoryName);
            categoryRepo.save(category);
        }
        return "redirect:/admin";
    }
}

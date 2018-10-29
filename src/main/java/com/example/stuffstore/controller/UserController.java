package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Role;
import com.example.stuffstore.entity.User;
import com.example.stuffstore.repository.CategoryRepo;
import com.example.stuffstore.repository.ProductRepo;
import com.example.stuffstore.repository.UserRepo;
import com.example.stuffstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    UserService userService;

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
        userService.saveUser(user,username,form);
        return "redirect:/admin/userList";
    }

}

package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Role;
import com.example.stuffstore.entity.User;
import com.example.stuffstore.repository.UserRepo;
import com.example.stuffstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        if (!userService.addUser(user)){
            model.addAttribute("message","This user is already created!");
            return "registration";
        }
        return "redirect:/login";
    }
}

package com.example.stuffstore.controller;

import com.example.stuffstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserContoller {
    @Autowired
    UserRepo userRepo;

}

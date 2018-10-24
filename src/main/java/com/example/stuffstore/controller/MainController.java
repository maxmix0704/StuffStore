package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String discription,
                             @RequestParam("file") MultipartFile file,
                             Model model) throws IOException
    {



        Product product = new Product(name,discription);
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
        return "main";
    }

    @GetMapping("/main")
    public String getMain(Model model){
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "main";
    }

    @GetMapping("/adminpage")
    public String getAdminPage(Model model){
        return "adminpage";
    }

    @RequestMapping("/logout")
    public String getLogout(){
        return "main";
    }

}

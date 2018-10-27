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

    @PostMapping("/productList/addProduct")
    public String addNewProduct(@RequestParam String name,
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
        return "redirect:/admin/productList";
    }

    @GetMapping("/productList")
    public String getProductList(Model model){
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products",products);
        return "productList";
    }

    @GetMapping("/productList/addProduct")
    public String getAddProductForm(Model model){
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories",categories);
        return "productAdd";
    }

    @GetMapping("/productList/{product}")
    public String productEditForm(@PathVariable Product product, Model model){
        model.addAttribute("product",product);
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories",categories);
        return "productEdit";
    }

    @GetMapping("/categoriesList")
    public String getCategoriesList(Model model){
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories",categories);
        return "categList";
    }

    @GetMapping("/categoriesList/addCategory")
    public String getAddCategoryForm(){
        return "categoryAdd";
    }

    @GetMapping("/categoriesList/{category}")
    public String categoryEditForm(@PathVariable Category category, Model model){
        model.addAttribute("category",category);
        return "categoryEdit";
    }

    @PostMapping("/categoriesList/{category}")
    public String categoryEdit(
            @RequestParam Long id,
            @RequestParam String category){
        Category categoryDb = categoryRepo.findById(id).get();
        categoryDb.setCategory(category);
        categoryRepo.save(categoryDb);
        return "redirect:/admin/categoriesList";
    }
    @PostMapping("/productList/{product}")
    public String productEdit(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String discription,
            @RequestParam String category_id,
            @RequestParam Float price
    ){
        Product product = productRepo.findById(id).get();
        Category category = categoryRepo.findById(Long.valueOf(category_id)).get();
        product.setName(name);
        product.setDiscription(discription);
        product.setCategory(category);
        product.setPrice(price);
        productRepo.save(product);
        return "redirect:/admin/productList";
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

    @PostMapping("/categoriesList/addCategory")
    public String addCategory(@RequestParam String category,
                              Model model) throws IOException
    {
        Category categoryBuf = new Category();
        if (!category.isEmpty()) {
            categoryBuf.setCategory(category);
            categoryRepo.save(categoryBuf);
        }
        return "redirect:/admin/categoriesList";
    }
}

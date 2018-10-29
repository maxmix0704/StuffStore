package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.repository.CategoryRepo;
import com.example.stuffstore.repository.ProductRepo;
import com.example.stuffstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/admin/categoriesList")
@PreAuthorize("hasAuthority('ADMIN')")
public class CategoryController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public String getCategoriesList(Model model){
        Iterable<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "categList";
    }

    @GetMapping("/{category}")
    public String getCategoryEditForm(@PathVariable Category category, Model model){
        model.addAttribute("category",category);
        return "categoryEdit";
    }

    @PostMapping("/{category}")
    public String categoryEdit(
            @PathVariable Category category,
            @RequestParam String categoryName){
        category.setCategory(categoryName);
        categoryService.save(category);
        return "redirect:/admin/categoriesList";
    }

    @GetMapping("/addCategory")
    public String getCategoryAddForm(){
        return "categoryAdd";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String category) throws IOException
    {
        Category categoryBuf = new Category();
        categoryBuf.setCategory(category);
        categoryService.save(categoryBuf);
        return "redirect:/admin/categoriesList";
    }

    @GetMapping("/delete/{id}")
            public String deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/admin/categoriesList";
    }

}

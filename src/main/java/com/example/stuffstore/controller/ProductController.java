package com.example.stuffstore.controller;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.entity.Product;
import com.example.stuffstore.services.CategoryService;
import com.example.stuffstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/productList")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getProductList(Model model){
        Iterable<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "productList";
    }

    @GetMapping("/{product}")
    public String getProductEditForm(@PathVariable Product product, Model model){
        model.addAttribute("product",product);
        Iterable<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "productEdit";
    }

    @PostMapping("/{product}")
    public String productEdit(
            @PathVariable Product product,
            @RequestParam String name,
            @RequestParam String discription,
            @RequestParam String category_id,
            @RequestParam Float price
    ){
        Category category = categoryService.getById(Long.valueOf(category_id));
        product.setName(name);
        product.setDiscription(discription);
        product.setCategory(category);
        product.setPrice(price);
        productService.saveProduct(product);
        return "redirect:/admin/productList";
    }

    @GetMapping("/addProduct")
    public String getProductAddForm(Model model){
        Iterable<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "productAdd";
    }

    @PostMapping("/addProduct")
    public String addProduct(
            @RequestParam String name,
            @RequestParam String discription,
            @RequestParam String category_id,
            @RequestParam Float price,
            @RequestParam("file") MultipartFile file
    ) throws IOException
    {
        Category category = categoryService.getById(Long.valueOf(category_id));
        Product product = new Product(name,discription);
        product.setPrice(price);
        product.setCategory(category);
        productService.addProduct(product,file);
        return "redirect:/admin/productList";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(
            @PathVariable Long id
    ){
        productService.delete(id);
        return "redirect:/admin/productList";
    }
}

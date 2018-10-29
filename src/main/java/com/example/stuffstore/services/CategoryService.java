package com.example.stuffstore.services;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public Iterable<Category> getAll(){
        return categoryRepo.findAll();
    }

    public Category getById(Long id){
        return categoryRepo.findById(id).get();
    }

    public void save(Category category){
        categoryRepo.save(category);
    }

    public void add(Category category){
        if (categoryRepo.findByCategory(category.getCategory())==null){
            categoryRepo.save(category);
        }
    }

    public void delete(Long id){
        Category category = categoryRepo.findById(id).get();
        categoryRepo.delete(category);
    }
}

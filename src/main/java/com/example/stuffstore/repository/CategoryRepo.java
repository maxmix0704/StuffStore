package com.example.stuffstore.repository;

import com.example.stuffstore.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,Long> {
}

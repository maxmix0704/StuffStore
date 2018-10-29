package com.example.stuffstore.repository;

import com.example.stuffstore.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Long> {
    Iterable<Product> findProductsByCategory_Category(String category);

}

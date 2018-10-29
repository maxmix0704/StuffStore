package com.example.stuffstore.services;

import com.example.stuffstore.entity.Category;
import com.example.stuffstore.entity.Product;
import com.example.stuffstore.repository.ProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public Iterable<Product> getAll(){
        return productRepo.findAll();
    }

    public void addProduct(Product product,MultipartFile file) throws IOException {
        if (file!=null&&!file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath+"/"+resultFilename));
            product.setFilename(resultFilename);
            productRepo.save(product);
        }
    }

    public void delete(Long id){
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
    }
}

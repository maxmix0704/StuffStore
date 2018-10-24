package com.example.stuffstore.repository;

import com.example.stuffstore.entity.User;
import com.example.stuffstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

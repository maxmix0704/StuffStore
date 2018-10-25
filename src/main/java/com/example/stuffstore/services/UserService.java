package com.example.stuffstore.services;

import com.example.stuffstore.entity.Role;
import com.example.stuffstore.entity.User;
import com.example.stuffstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb!=null){
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return true;
    }

}

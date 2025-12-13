package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

public class UserDetailsServiceImple implements UserDetailsService {

    @Autowired
    UserRepository urepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User u = urepo.getUserWithUsername(username);

        if (u == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return UserDetailsImple.build(u);
    }
}

package com.RestApi.GradleApi.service.userService.impl;

import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.passwordservice.repo.PasswordRepo;
import com.RestApi.GradleApi.service.userService.entities.User;
import com.RestApi.GradleApi.service.userService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service                                                                                                                                                                                                                                                                                                                
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordRepo passwordRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            System.out.println(user.toString());
            return new UserDetailsImpl(user);

        } else {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }
}



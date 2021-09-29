package com.RestApi.GradleApi.service.userService.impl;


import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.userService.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class UserDetailsImpl implements UserDetails {

    private User user;

//    @Autowired
//    private UserRepo userRepo;

    UserDetailsImpl(User user){
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (user.getPassword().isPasswordExpired()) {
            System.out.println("User: " + user.getUsername() + " - Password Expireds:");
            System.out.println("Last time password changeds: " + user.getPassword().getPasswordChangedTime());
            System.out.println("Current times: " + new Date());
            return false;
        }else {
            System.out.println("Customer: " + user.getUsername() + " - Password Not Expired:");
            return true;
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public User getUser(){
        return this.user;
    }


    public Password password(){
        return this.password();
    }


}
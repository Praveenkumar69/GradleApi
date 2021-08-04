package com.RestApi.GradleApi.service;

import com.RestApi.GradleApi.entities.User;
import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

//    @Autowired
//    public UserServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
    @Override
    public User saveUser(User user) {
        if (userRepo.existsById(user.getId())){
            throw new EmailAlreadyExists();
        }
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
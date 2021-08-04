package com.RestApi.GradleApi.service;

import com.RestApi.GradleApi.entities.User;
import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.exception.EmailNotFound;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws EmailAlreadyExists;
    User getUser(String username) throws EmailNotFound;
    List<User>getUsers() throws EmailNotFound;
}

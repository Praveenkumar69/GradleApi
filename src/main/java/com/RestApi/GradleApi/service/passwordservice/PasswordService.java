package com.RestApi.GradleApi.service.passwordservice;

import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.exception.ValidationException;
import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.userService.entities.User;

import java.util.Optional;

public interface PasswordService {


    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

package com.RestApi.GradleApi.controller;

import com.RestApi.GradleApi.domain.AuthRequest;
import com.RestApi.GradleApi.domain.UserRequest;
import com.RestApi.GradleApi.exception.ValidationException;
import com.RestApi.GradleApi.exception.constants.ExceptionConstants;
import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.passwordservice.repo.PasswordRepo;
import com.RestApi.GradleApi.service.userService.entities.User;
import com.RestApi.GradleApi.service.userService.mapper.MapServer;
import com.RestApi.GradleApi.service.userService.repo.UserRepo;
import com.RestApi.GradleApi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MapServer mapServer;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private PasswordRepo passwordRepo;

    @GetMapping("/")
    public String hello() {
        return "Welcome to hello world";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to hello worlds";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserRequest userRequest){

        //check validation in Registration form
        if (userRepo.existsByUsername(userRequest.getUsername())){
            throw new ValidationException(ExceptionConstants.USER_IS_ALREADY);
        }
        if (userRepo.existsByEmail(userRequest.getEmail())){
            throw new ValidationException(ExceptionConstants.EMAIL_IS_ALREADY);
        }
            // Create new user's account
            Password password = mapServer.createPassword(userRequest);
            passwordRepo.save(password);
            User user = mapServer.createUser(password, userRequest);
            userRepo.save(user);

        return "User Registered Successfully";
    }

    @PostMapping("/change_password")
    public String change_password(@RequestParam String email){

        String response = mapServer.change_password(email);

        if (!response.startsWith("Invalid")){
            response = "http://localhost:8080/password_change_process?token=" + response;
        }
//        return "Login again!! You have change your password successfully.";
        return response;
    }

    @PutMapping("/password_change_process")
    public String passwordProcess(@RequestParam String token,@RequestParam String oldPassword,String newPassword,String confirmPassword){


        return mapServer.passwordProcess(token,oldPassword,newPassword,confirmPassword);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){

        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new ValidationException(ExceptionConstants.EMAIL_NOT_FOUND);
        }
        if (!authenticate.isAuthenticated())
            throw new ValidationException(ExceptionConstants.EMAIL_NOT_FOUND);

        return jwtUtil.generateToken(authRequest.getUsername());
    }

}

package com.RestApi.GradleApi.controller;

import com.RestApi.GradleApi.entities.User;
import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.exception.EmailNotFound;
import com.RestApi.GradleApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers() throws EmailNotFound {
        return ResponseEntity.ok().body(userService.getUsers());
    }

//    @GetMapping("/user")
//    private List<User> getAll() {
//        return userService.getAll();
//    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user) throws EmailAlreadyExists {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @ExceptionHandler(value = EmailAlreadyExists.class)
    public ResponseEntity handleBlogAlreadyExistsException(EmailAlreadyExists EmailAlreadyExists) {
        return new ResponseEntity("Email already exists", HttpStatus.CONFLICT);
    }

}

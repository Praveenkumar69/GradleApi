package com.RestApi.GradleApi.controller;

import com.RestApi.GradleApi.domain.AuthRequest;
import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.service.UserService;
import com.RestApi.GradleApi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @GetMapping("/users")
//    public ResponseEntity<List<User>>getUsers() throws EmailNotFound {
//        return ResponseEntity.ok().body(userService.getUsers());
//    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome to hello world";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );
        }catch (Exception e){
            throw new  Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }


//    @PostMapping("/user/save")
//    public ResponseEntity<User>saveUser(@RequestBody User user) throws EmailAlreadyExists {
//        return ResponseEntity.ok().body(userService.saveUser(user));
//    }
    @ExceptionHandler(value = EmailAlreadyExists.class)
    public ResponseEntity handleBlogAlreadyExistsException(EmailAlreadyExists EmailAlreadyExists) {
        return new ResponseEntity("Email already exists", HttpStatus.CONFLICT);
    }

}

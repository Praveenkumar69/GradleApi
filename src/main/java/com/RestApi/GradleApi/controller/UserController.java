package com.RestApi.GradleApi.controller;

import com.RestApi.GradleApi.domain.AuthRequest;
import com.RestApi.GradleApi.exception.EmailAlreadyExists;
import com.RestApi.GradleApi.exception.ValidationException;
import com.RestApi.GradleApi.exception.constants.ExceptionConstants;
import com.RestApi.GradleApi.service.UserService;
import com.RestApi.GradleApi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String welcome() {
        return "Welcome to hello world";
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

//    @PostMapping("/authenticate")
//    public ResponseEntity<?> generateTokens(@RequestBody AuthRequest authRequest) throws Exception {
//        try {
//            authenticationManager
//                    .authenticate(
//                            new UsernamePasswordAuthenticationToken(
//                                    authRequest.getUsername(), authRequest.getPassword()
//                            )
//                    );
//
////            User user = (User) authenticate.getPrincipal();
////
//            return ResponseEntity.ok()
//                    .header(
//                            HttpHeaders.AUTHORIZATION,
//                            jwtUtil.generateToken(authRequest.getUsername())
//                    ).body(authRequest);
//        } catch (Exception ex) {
//            EmailAlreadyExists exists = new EmailAlreadyExists("invalid username/password");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exists);
//        }
////        return jwtUtil.generateToken(authRequest.getUsername());
////        return null;
//    }


    //    @PostMapping("/user/save")
//    public ResponseEntity<User>saveUser(@RequestBody User user) throws EmailAlreadyExists {
//        return ResponseEntity.ok().body(userService.saveUser(user));
//    }


}

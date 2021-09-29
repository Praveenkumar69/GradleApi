package com.RestApi.GradleApi.service.userService.mapper;

import com.RestApi.GradleApi.domain.AuthRequest;
import com.RestApi.GradleApi.domain.UserRequest;
import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.passwordservice.repo.PasswordRepo;
import com.RestApi.GradleApi.service.userService.entities.User;
import com.RestApi.GradleApi.service.userService.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Qualifier("MapService")
public class MapServer {

    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ModelMapper modelMapper;

    public User createUser(Password password, UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(password);
        return user;
    }

    public Password createPassword(UserRequest userRequest){
        Password password = new Password();
        password.setPassword(encoder.encode(userRequest.getPassword()));
//        password.setCreatedAt(LocalDateTime.from(Instant.now()));
//        password.setUpdatedAt(LocalDateTime.from(Instant.now()));
        return password;
    }


    public String change_password(String email) {

        Optional<User> userOptional = Optional
                .ofNullable(userRepo.findByEmail(email));

        if (!userOptional.isPresent()) {
            return "Invalid email id.";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
//        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepo.save(user);

        return user.getToken();
    }

    private String generateToken(){
        StringBuffer Token = new StringBuffer();

        return Token.append(UUID.randomUUID().toString()).
                append(UUID.randomUUID().toString()).toString();
    }

    public String passwordProcess(String token,String oldPassword,String newPassword,String confirmPassword){
        Optional<User> userOptional = Optional.
                ofNullable(userRepo.findByToken(token));

        if (!userOptional.isPresent()){
            return "Invalid token.";
        }
        // Create new expire password
        User user = userOptional.get();
        if (!encoder.matches(oldPassword, user.getPassword().getPassword())) {
            return "Your old password is incorrect.";
        }

        if (oldPassword.equals(newPassword)) {
            return "Your new password must be different than the old one.";
        }

        if (!newPassword.equals(confirmPassword)){
            return "Passwords do not match!";
        }
//        System.out.println("userPassword = " + user + " newPassword " + newPassword + " confirmPassword " + confirmPassword + " oldPassword " + oldPassword);
        user.getPassword().setPassword(encoder.encode(newPassword));
        user.getPassword().setPasswordChangedTime(new Date());
        user.getPassword().setUpdatedAt(new Date());

        userRepo.save(user);
        return "Your password successfully updated.";
    }



}

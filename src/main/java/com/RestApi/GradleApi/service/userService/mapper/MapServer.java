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

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
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


//    public List<UserDto> getAllUserPassword(){
//        return passwordRepo.findAll().stream().map(this::convertToUserPasswordDTO).
//                collect(Collectors.toList());
//    }
//
//    private UserDto convertToUserPasswordDTO(Password password){
//        UserDto userDto = new UserDto();
//        userDto.setUserId(password.getUser().getUserid());
//        userDto.setUsername(password.getUser().getUsername());
//        userDto.setEmail(password.getUser().getEmail());
//        userDto.setPassword(password.getPassword());
//        return userDto;
//   }
//
//   public void addPassword(UserDto userDto){
//       User user = new ModelMapper().map(userDto,User.class);
//       userRepo.save(user);
//       userDto.setPassword(userDto.getPassword());
//       passwordRepo.save(getPasswordEntity(userDto,user));
//   }
//
//    private Password getPasswordEntity(UserDto userDto, User user) {
//        Password password = new Password();
//        password.setPassword(userDto.getPassword());
//        password.setCreatedAt(LocalDateTime.now());
//        password.setUser(user);
//        userDto.setPassword(userDto.getPassword());
//        passwordRepo.save(getPasswordEntity(userDto,user));
//        return password;
//    }
}

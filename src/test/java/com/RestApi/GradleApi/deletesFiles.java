package com.RestApi.GradleApi;

public class deletesFiles {

    //  UserController files----------------
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

    // --------- SecurityConfig


//    public void messgeDigest(){
//        String s = "praveen";
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
//    }

    // ------------

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId",referencedColumnName = "userId")
//    private User user;

    //------------------

    //    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findByUsername(username);
////        if (user.isPasswordExpired() == true){
////
////        }
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword().getPassword(),new ArrayList<>());
//    }
//
//}

    //---------------UserDetailsImpl

    //    public void updatePassword(String newPassword, User user, PasswordEncoder passwordEncoder) {
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        user.getPassword().setPassword(encodedPassword);
//        user.getPassword().setPasswordChangedTime(new Date());
//        userRepo.save(user);
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        UserDetailsImpl user = (UserDetailsImpl) o;
//        return Objects.equals(id, user.id);
//    }

    //------------------------- MapServer

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

package com.RestApi.GradleApi.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity @NoArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min=2, max=30)
    private String username;

    @Email(message = "Email invalid")
    @Column(unique = true,name = "email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank
    @Size(min=2)
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Pattern.Flag.UNICODE_CASE)
    private String password;
    @NotBlank
    @Size(min=2)
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Pattern.Flag.UNICODE_CASE)
    private String passwordConfirmation;

    public User(Long id, String username, String email, String password, String passwordConfirmation) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
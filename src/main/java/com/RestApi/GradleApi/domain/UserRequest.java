package com.RestApi.GradleApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long userId;

    private String username;

    @Email(message = "Email invalid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank
    @Size(min=2)
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Pattern.Flag.UNICODE_CASE)
    private String password;

}
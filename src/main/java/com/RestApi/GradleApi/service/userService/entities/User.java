package com.RestApi.GradleApi.service.userService.entities;

import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userid;
    private String username;

    @Column(unique = true,name = "email")
    private String email;

    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passwordId",referencedColumnName = "passwordId")
    private Password password;

}
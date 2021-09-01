package com.RestApi.GradleApi.service.passwordservice.entities;

import com.RestApi.GradleApi.service.userService.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passwordId")
    private int passwordId;

    @NotBlank
    @Size(min=2)
//    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Pattern.Flag.UNICODE_CASE)
    @Column(name = "password")
    private String password;


    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId",referencedColumnName = "userId")
//    private User user;

}

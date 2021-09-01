package com.RestApi.GradleApi.service.passwordservice.repo;

import com.RestApi.GradleApi.service.passwordservice.entities.Password;
import com.RestApi.GradleApi.service.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepo extends JpaRepository<Password,Integer> {
    Password findByPassword(String password);
}

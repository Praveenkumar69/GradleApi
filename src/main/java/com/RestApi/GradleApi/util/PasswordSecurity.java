package com.RestApi.GradleApi.util;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordSecurity {

    @SneakyThrows
    public static String passwordHash(String s){
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
        return new String(digest);
    }
}

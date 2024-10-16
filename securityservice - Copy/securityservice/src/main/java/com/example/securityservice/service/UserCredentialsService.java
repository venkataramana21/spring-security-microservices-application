package com.example.securityservice.service;

import com.example.securityservice.controller.UserCredentialsController;
import com.example.securityservice.model.UserCredentials;
import com.example.securityservice.repository.UserCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {
    @Autowired
    UserCredentialsDao userCredentialsDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    jwtService jwtservice;

    public UserCredentials register(UserCredentials userCredentials) {
        userCredentials.setPassword((passwordEncoder.encode(userCredentials.getPassword())));
        return userCredentialsDao.saveAndFlush(userCredentials);
    }

    public boolean verifyToken(String token) {
        jwtservice.validateToken(token);
        return true;

    }
}

package com.example.securityservice.service;

import com.example.securityservice.controller.UserCredentialsController;
import com.example.securityservice.model.UserCredentials;
import com.example.securityservice.repository.UserCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserCredentialsDao userCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Optional<UserCredentials>user= userCredentialsDao.findByUsername(username);
       return user.map(CustomUserDetails::new)
               .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

}

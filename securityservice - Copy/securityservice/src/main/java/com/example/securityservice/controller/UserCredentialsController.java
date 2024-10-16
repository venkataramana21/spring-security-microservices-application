package com.example.securityservice.controller;

import com.example.securityservice.model.UserCredentials;
import com.example.securityservice.service.UserCredentialsService;
import com.example.securityservice.service.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
    @Autowired
    UserCredentialsService userCredentialsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtService jwtservice;

    @PostMapping("/register")
    public UserCredentials register(@RequestBody UserCredentials userCredentials){
        return userCredentialsService.register(userCredentials);
    }

    @PostMapping("/validate/user")
    public String getToken(@RequestBody UserCredentials user){
        Authentication  authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtservice.generateToken(user.getUsername());
        }
        return "Failed";
    }

    @GetMapping("/validate/token")
    public boolean validateToken(@RequestParam String token){
        return userCredentialsService.verifyToken(token);
    }

}

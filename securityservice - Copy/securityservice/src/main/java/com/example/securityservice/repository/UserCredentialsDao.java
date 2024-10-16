package com.example.securityservice.repository;

import com.example.securityservice.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentials,Integer> {

    Optional<UserCredentials> findByUsername(String username);
}

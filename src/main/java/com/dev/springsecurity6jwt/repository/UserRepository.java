package com.dev.springsecurity6jwt.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.springsecurity6jwt.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    
}

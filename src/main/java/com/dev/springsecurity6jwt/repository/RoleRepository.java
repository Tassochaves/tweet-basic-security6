package com.dev.springsecurity6jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.springsecurity6jwt.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}

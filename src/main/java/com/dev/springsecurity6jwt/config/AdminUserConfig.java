package com.dev.springsecurity6jwt.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dev.springsecurity6jwt.entities.Role;
import com.dev.springsecurity6jwt.entities.User;
import com.dev.springsecurity6jwt.repository.RoleRepository;
import com.dev.springsecurity6jwt.repository.UserRepository;

import jakarta.transaction.Transactional;

@Configuration
public class AdminUserConfig implements CommandLineRunner{

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(
        RoleRepository roleRepository,
        UserRepository userRepository,
        BCryptPasswordEncoder passwordEncoder
    ){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
            user -> {
                System.out.println("Admin já existe");
            },
            () -> {
                var user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("85294"));
                user.setRoles(Set.of(roleAdmin));
                userRepository.save(user);
            });
    }
    
}

package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.LoginResponse;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

@Service
public class AuthService {

    @Autowired private AuthenticationManager authManager;
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private UserLogService logService;

    public LoginResponse authenticate(LoginRequest request) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userRepo.findByUsername(request.getUsername()).get();
        logService.log(user.getUsername(), "LOGIN");

        System.out.println("DB hash: " + user.getPassword());
        System.out.println("Raw input: " + request.getPassword());
        System.out.println("Match: " + encoder.matches(request.getPassword(), user.getPassword()));


        return new LoginResponse(user.getUsername());
    }
}


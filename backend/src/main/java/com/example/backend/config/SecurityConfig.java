package com.example.backend.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/customers/**").permitAll() // 👈 allow public access
            .anyRequest().authenticated()
        )
        .formLogin(form -> form.disable())
        .build();
        // return http
        // .csrf(csrf -> csrf.disable())
        // .authorizeHttpRequests(auth -> auth
        //     .requestMatchers("/api/auth/**").permitAll()  // 👈 THIS LINE IS CRUCIAL
        //     .anyRequest().authenticated()
        // )
        // .formLogin(form -> form.disable()) // 👈 disables default login page
        // .httpBasic(Customizer.withDefaults())  // optional for testing
        // .build();
        // return http
        //     .csrf(csrf -> csrf.disable())
        //     .authorizeHttpRequests(auth -> auth
        //         .requestMatchers("/api/auth/**").permitAll()
        //         .anyRequest().authenticated()
        //     )
        //     .formLogin().and()
        //     .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

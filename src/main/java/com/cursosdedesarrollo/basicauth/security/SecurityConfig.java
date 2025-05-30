package com.cursosdedesarrollo.basicauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())           // si no necesitas CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin")
                        .hasRole("ADMIN")               // solo ROLE_ADMIN puede acceder a /admin/**
                        .requestMatchers("/user/**")
                        .hasAnyRole("USER", "ADMIN")    // ROLE_USER o ROLE_ADMIN
                        .requestMatchers("/public/**")
                        .permitAll()
                        .anyRequest().authenticated()       // el resto, autenticado
                )
                .formLogin(Customizer.withDefaults())     // login por formulario
                .httpBasic(Customizer.withDefaults());    // y/o autenticación HTTP Basic
        return http.build();
    }

}


package com.cursosdedesarrollo.basicauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    /*
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
                        .requestMatchers("/api/auth/**")
                        .permitAll()
                        .anyRequest().authenticated()       // el resto, autenticado
                )
                .formLogin(Customizer.withDefaults())     // login por formulario
                .httpBasic(Customizer.withDefaults());    // y/o autenticación HTTP Basic
        return http.build();
    }

     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // configuración específica para que funcione bien la consola de h2
        http.headers(headers -> {
            headers.frameOptions(frameOptions -> frameOptions.sameOrigin()); // Nueva forma de configurar frameOptions
        });
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers("/api/auth/**").permitAll();
                    // configuración específica para que funcione bien la consola de h2
                    authorize.requestMatchers("/h2-console/**").permitAll();
                    /*
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/api/admin").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/api/user").hasRole("USER");

                     */
                    authorize
                            .requestMatchers("/admin")
                            .hasRole("ADMIN")               // solo ROLE_ADMIN puede acceder a /admin/**
                            .requestMatchers("/user/**")
                            .hasAnyRole("USER", "ADMIN")    // ROLE_USER o ROLE_ADMIN
                            .requestMatchers("/public/**")
                            .permitAll()
                            .requestMatchers("/api/auth/**")
                            .permitAll();// el resto, autenticado
//                    authorize.requestMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole("ADMIN", "USER");
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());

        http.exceptionHandling( exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}


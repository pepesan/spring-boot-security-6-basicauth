package com.cursosdedesarrollo.basicauth.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity(
        prePostEnabled = true,     // para @PreAuthorize
        securedEnabled   = true,   // para @Secured
        jsr250Enabled    = true    // para @RolesAllowed
)
public class MethodSecurityConfig { }

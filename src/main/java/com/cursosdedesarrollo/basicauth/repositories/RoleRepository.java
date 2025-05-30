package com.cursosdedesarrollo.basicauth.repositories;

import com.cursosdedesarrollo.basicauth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

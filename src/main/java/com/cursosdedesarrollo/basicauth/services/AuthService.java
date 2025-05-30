package com.cursosdedesarrollo.basicauth.services;


import com.cursosdedesarrollo.basicauth.dtos.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}

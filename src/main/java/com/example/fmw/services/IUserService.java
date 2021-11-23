package com.example.fmw.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.fmw.entity.AdminRegistration;
import com.example.fmw.entity.User;

public interface IUserService extends UserDetailsService{
    User save(AdminRegistration registrationDto);
    User findByUsername(String username);   
    User save2(AdminRegistration registrationDto);


}

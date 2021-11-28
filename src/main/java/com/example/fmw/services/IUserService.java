package com.example.fmw.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.fmw.entity.User;

public interface IUserService extends UserDetailsService{
    User findByUsername(String username);   
	User save(User user);


}

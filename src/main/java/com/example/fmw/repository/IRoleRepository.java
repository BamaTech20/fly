package com.example.fmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fmw.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
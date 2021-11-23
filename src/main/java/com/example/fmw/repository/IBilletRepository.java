package com.example.fmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fmw.entity.Billet;

@Repository
public interface IBilletRepository extends JpaRepository<Billet, Long> {

}
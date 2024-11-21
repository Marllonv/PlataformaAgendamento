package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, String>{
    UserDetails findByMatricula(String matricula);
} 


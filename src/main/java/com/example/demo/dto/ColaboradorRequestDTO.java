package com.example.demo.dto;

import com.example.demo.entity.UserRole;

public record ColaboradorRequestDTO(String matricula, String senha, String nome, String email, UserRole role) {
    
}

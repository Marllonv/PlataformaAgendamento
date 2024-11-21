package com.example.demo.dto;

import com.example.demo.entity.Colaborador;

public record ColaboradorResponseDTO(String id, String matricula, String senha, String nome, String email) {
    public ColaboradorResponseDTO(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getMatricula(), colaborador.getSenha(), colaborador.getNome(), colaborador.getEmail());
    }
}
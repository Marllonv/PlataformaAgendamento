package com.example.demo.dto;

import com.example.demo.entity.UserRole;

public record FornecedorRequestDTO(String idFornecedor, String senha, String razao_social, String nome_fantasia, String cnpj, UserRole role) {

} 

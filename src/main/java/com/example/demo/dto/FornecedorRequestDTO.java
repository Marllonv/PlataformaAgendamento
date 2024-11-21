package com.example.demo.dto;

import com.example.demo.entity.UserRole;

public record FornecedorRequestDTO(String id_fornecedor, String senha, String razao_social, String nome_fantasia, String cnpj, UserRole role) {

} 

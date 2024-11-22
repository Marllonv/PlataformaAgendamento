package com.example.demo.dto;

import com.example.demo.entity.Fornecedor;

public record FornecedorResponseDTO(String id, String id_fornecedor, String senha, String razao_social, String nome_fantasia, String cnpj) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getId(), fornecedor.getIdFornecedor(), fornecedor.getSenha(), fornecedor.getRazao_social(), fornecedor.getNome_fantasia(), fornecedor.getCnpj());
    }
}

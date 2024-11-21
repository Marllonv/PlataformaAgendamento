package com.example.demo.dto;

public record FornecedorResponseDTO(String id_fornecedor, String senha, String razao_social, String nome_fantasia, String cnpj) {
    public FornecedorResponseDTO(com.example.demo.entity.Fornecedor fornecedor){
        this(fornecedor.getIdFornecedor(), fornecedor.getSenha(), fornecedor.getRazao_social(), fornecedor.getNome_fantasia(), fornecedor.getCnpj());
    }
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
    UserDetails findByIdFornecedor(String id_fornecedor);
}

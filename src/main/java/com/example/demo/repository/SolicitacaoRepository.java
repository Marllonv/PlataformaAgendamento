package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    Optional<Solicitacao> findById(Long id); // Renamed method

    List<Solicitacao> findByFornecedor(String fornecedor); // Use findByFornecedor
}

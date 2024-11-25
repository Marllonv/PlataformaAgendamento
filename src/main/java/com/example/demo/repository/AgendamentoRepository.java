package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
    @SuppressWarnings("null")
    Optional<Agendamento> findById(Long id); // Renamed method

    List<Agendamento> findByFornecedor(String fornecedor); // Use findByFornecedor
}

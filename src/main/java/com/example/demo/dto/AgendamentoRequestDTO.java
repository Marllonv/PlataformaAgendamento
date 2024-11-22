package com.example.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AgendamentoRequestDTO(Long id, String fornecedor, String tipoCarga, String tipoDescarga, String recorrencia, String observacao, @JsonFormat(pattern="dd/MM/yyyy") LocalDate data) {
    
}

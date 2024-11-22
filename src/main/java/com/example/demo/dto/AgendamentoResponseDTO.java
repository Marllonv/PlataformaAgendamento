package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Agendamento;

public record AgendamentoResponseDTO(Long id, String fornecedor, String tipoCarga, String tipoDescarga, String recorrencia, String observacao, LocalDate data) {
    public AgendamentoResponseDTO(Agendamento agendamento){
        this(agendamento.getId(), agendamento.getFornecedor(), agendamento.getTipoCarga(), agendamento.getTipoDescarga(), agendamento.getRecorrencia(), agendamento.getObservacao(), agendamento.getData());
    }
}

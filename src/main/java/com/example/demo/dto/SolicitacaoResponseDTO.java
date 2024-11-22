package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Solicitacao;

public record SolicitacaoResponseDTO(Long id, String fornecedor, String tipoCarga, String tipoDescarga, String recorrencia, String observacao, LocalDate data) {
    public SolicitacaoResponseDTO(Solicitacao solicitacao){
        this(solicitacao.getId(), solicitacao.getFornecedor(), solicitacao.getTipoCarga(), solicitacao.getTipoDescarga(), solicitacao.getRecorrencia(), solicitacao.getObservacao(), solicitacao.getData());
    }
}

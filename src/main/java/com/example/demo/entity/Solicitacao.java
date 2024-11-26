package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.dto.SolicitacaoRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "solicitacoes")
@Table(name = "solicitacoes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Solicitacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    private String fornecedor;

    private String tipoCarga;

    private String tipoDescarga;

    private String recorrencia;

    private String observacao;

    private LocalDate data;
    
    public Solicitacao(SolicitacaoRequestDTO data) {
        this.fornecedor = data.fornecedor();
        this.tipoCarga = data.tipoCarga();
        this.tipoDescarga = data.tipoDescarga();
        this.recorrencia = data.recorrencia();
        this.observacao = data.observacao();
        this.data = data.data();
    }

    public Long getId() {
        return id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public String getTipoDescarga() {
        return tipoDescarga;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public LocalDate getData() {
        return data;
    }

}

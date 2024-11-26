package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "agendamentos")
@Table(name = "agendamentos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    private Long id;

    private String fornecedor;

    private String tipoCarga;

    private String tipoDescarga;

    private String recorrencia;

    private String observacao;

    private LocalDate data;
    
    public Agendamento(Solicitacao solicitacao) {
        this.id = solicitacao.getId();
        this.fornecedor = solicitacao.getFornecedor();
        this.tipoCarga = solicitacao.getTipoCarga();
        this.tipoDescarga = solicitacao.getTipoDescarga();
        this.recorrencia = solicitacao.getRecorrencia();
        this.observacao = solicitacao.getObservacao();
        this.data = solicitacao.getData();
    }

    // Getters using traditional approach (without Lombok)
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

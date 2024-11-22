package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.dto.SolicitacaoRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "solicitacoes")
@Table(name = "solicitacoes")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Solicitacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
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
@Data
@Getter
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
    
}

package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FornecedorResponseDTO;
import com.example.demo.dto.SolicitacaoRequestDTO;
import com.example.demo.dto.SolicitacaoResponseDTO;
import com.example.demo.entity.Solicitacao;
import com.example.demo.repository.SolicitacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("solicitacao")
public class SolicitacaoController {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @PostMapping("/criar")
    public ResponseEntity saveSolicitacao(@RequestBody @Valid SolicitacaoRequestDTO data) {
        Solicitacao novaSolicitacao = new Solicitacao(data);
        solicitacaoRepository.save(novaSolicitacao);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")  
    @GetMapping("/buscar")
    public List<SolicitacaoResponseDTO> getAll(){

        List<SolicitacaoResponseDTO> solicitacaoList = solicitacaoRepository.findAll().stream().map(SolicitacaoResponseDTO::new).toList();
        return solicitacaoList;
    }

    
}

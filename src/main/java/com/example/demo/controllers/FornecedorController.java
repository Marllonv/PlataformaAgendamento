package com.example.demo.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FornecedorRequestDTO;
import com.example.demo.dto.FornecedorResponseDTO;
import com.example.demo.entity.Agendamento;
import com.example.demo.entity.Fornecedor;
import com.example.demo.entity.Solicitacao;
import com.example.demo.repository.AgendamentoRepository;
import com.example.demo.repository.FornecedorRepository;
import com.example.demo.repository.SolicitacaoRepository;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
    
    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")  
    @GetMapping
    public List<FornecedorResponseDTO> getAll(){

        List<FornecedorResponseDTO> fornecedorList = repository.findAll().stream().map(FornecedorResponseDTO::new).toList();
        return fornecedorList;
    }

    @GetMapping("/minhas-solicitacoes")
    public List<Solicitacao> getSolicitacoesByFornecedor(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) userDetails;
            List<Solicitacao> solicitacoes = solicitacaoRepository.findByFornecedor(fornecedor.getIdFornecedor());
            return solicitacoes;
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/meus-agendamentos")
    public List<Agendamento> getAgendamentosByFornecedor(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) userDetails;
            List<Agendamento> agendamentos = agendamentoRepository.findByFornecedor(fornecedor.getIdFornecedor());
            return agendamentos;
        } else {
            return Collections.emptyList();
        }
    }

    @DeleteMapping("/excluir-solicitacao/{id}")
    public ResponseEntity deleteSolicitacao(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Solicitacao> sOptional = solicitacaoRepository.findById(id);
        Fornecedor fornecedor = (Fornecedor) userDetails;
        if (userDetails instanceof Fornecedor) {
            if(sOptional.isPresent()) {
                Solicitacao solicitacao = sOptional.get();
                if (isFornecedorOwner(solicitacao, fornecedor)) {
                    solicitacaoRepository.delete(solicitacao);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.badRequest().build();
                }
            }
        }
        return ResponseEntity.notFound().build();

    }

    // Optional method to check ownership (replace with your implementation)
    private boolean isFornecedorOwner(Solicitacao solicitacao, Fornecedor fornecedor) {
    if (solicitacao.getFornecedor().equals(fornecedor.getIdFornecedor())) {
        return true;
    } else {
        return false;
    }
    
    }
}

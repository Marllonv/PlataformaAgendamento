package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AgendamentoResponseDTO;
import com.example.demo.dto.SolicitacaoResponseDTO;
import com.example.demo.entity.Agendamento;
import com.example.demo.entity.Solicitacao;
import com.example.demo.repository.AgendamentoRepository;
import com.example.demo.repository.SolicitacaoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("agendamento")
public class AgendamentoController {
    
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")  
    @PostMapping("/criar")
    public ResponseEntity criarAgendamento(@RequestBody Long id) {

        Optional<Solicitacao> solicitacaoOptional = solicitacaoRepository.findById(id);

        if (solicitacaoOptional.isPresent()) {
            Solicitacao solicitacao = solicitacaoOptional.get();
            Agendamento agendamento = new Agendamento(solicitacao);
            agendamentoRepository.save(agendamento);
            solicitacaoRepository.delete(solicitacao);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")  
    @GetMapping("/buscar")
    public List<AgendamentoResponseDTO> getAll(){

        List<AgendamentoResponseDTO> agendamentoList = agendamentoRepository.findAll().stream().map(AgendamentoResponseDTO::new).toList();
        return agendamentoList;
    }
}

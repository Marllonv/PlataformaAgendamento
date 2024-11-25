package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ColaboradorRequestDTO;
import com.example.demo.dto.ColaboradorResponseDTO;
import com.example.demo.entity.Colaborador;
import com.example.demo.repository.ColaboradorRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository repository;

    @GetMapping
    public List<ColaboradorResponseDTO> getAll(){
        List<ColaboradorResponseDTO> colaboradorList = repository.findAll().stream().map(ColaboradorResponseDTO::new).toList();
        return colaboradorList;
    }
    
}
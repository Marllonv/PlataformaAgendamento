package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FornecedorRequestDTO;
import com.example.demo.dto.FornecedorResponseDTO;
import com.example.demo.entity.Fornecedor;
import com.example.demo.repository.FornecedorRepository;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
    
    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    public void saveFornecedor(@RequestBody FornecedorRequestDTO data){
        Fornecedor fornecedorData = new Fornecedor(data);
        repository.save(fornecedorData);
        return;
        
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")  
    @GetMapping
    public List<FornecedorResponseDTO> getAll(){

        List<FornecedorResponseDTO> fornecedorList = repository.findAll().stream().map(FornecedorResponseDTO::new).toList();
        return fornecedorList;
    }
}

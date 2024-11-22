package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthDTO;
import com.example.demo.dto.ColaboradorRequestDTO;
import com.example.demo.dto.FornecedorRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.entity.Colaborador;
import com.example.demo.entity.Fornecedor;
import com.example.demo.repository.ColaboradorRepository;
import com.example.demo.repository.FornecedorRepository;
import com.example.demo.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        Object principal = auth.getPrincipal();
        String token = null;
        if (principal instanceof Colaborador) {
            token = tokenService.generateToken((Colaborador) auth.getPrincipal());
        } else if (principal instanceof Fornecedor){
            token = tokenService.generateToken((Fornecedor) auth.getPrincipal());
        } else {
            token = "";
        }
        
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register/colaborador")
    public ResponseEntity registerColaborador(@RequestBody @Valid ColaboradorRequestDTO data) {
        if (this.colaboradorRepository.findByMatricula(data.matricula()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        
        Colaborador colaboradorData = new Colaborador(data.matricula(), encryptedPassword, data.nome(), data.email(), data.role());

        this.colaboradorRepository.save(colaboradorData);

        return ResponseEntity.ok().build();
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register/fornecedor")
    public ResponseEntity registerFornecedor(@RequestBody @Valid FornecedorRequestDTO data) {
        if (this.fornecedorRepository.findByIdFornecedor(data.idFornecedor()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Fornecedor fornecedorData = new Fornecedor(data.idFornecedor(), encryptedPassword, data.razao_social(), data.nome_fantasia(), data.cnpj(), data.role());

        this.fornecedorRepository.save(fornecedorData);

        return ResponseEntity.ok().build();
    }

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ColaboradorRepository;
import com.example.demo.repository.FornecedorRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = colaboradorRepository.findByMatricula(username);
        if (user == null) {
            user = fornecedorRepository.findByIdFornecedor(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return user;
    }
    
}

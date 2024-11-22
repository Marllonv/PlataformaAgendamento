package com.example.demo.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.repository.ColaboradorRepository;
import com.example.demo.repository.FornecedorRepository;
import com.example.demo.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    ColaboradorRepository colaboradorRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                var token = this.recoverToken(request);
                if (token != null) {
                    var login = tokenService.validateToken(token);
                    UserDetails user = null;

                    if (colaboradorRepository.findByMatricula(login) != null) {
                        user = colaboradorRepository.findByMatricula(login);
                    } else if (fornecedorRepository.findByIdFornecedor(login) != null) {
                        user = fornecedorRepository.findByIdFornecedor(login);
                    } 
                    if (user != null) {
                        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);    
                    } else {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
                    }
                    
                    
                }
                filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
    
}

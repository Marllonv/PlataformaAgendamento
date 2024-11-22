package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.ColaboradorRequestDTO;

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

@Entity(name = "colaboradores")
@Data
@Table(name = "colaboradores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "matricula")
public class Colaborador implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String matricula;

    private String senha;

    private String nome;

    private String email;

    private UserRole role;

    public Colaborador(ColaboradorRequestDTO data) {
        this.matricula = data.matricula();
        this.senha = data.senha();
        this.nome = data.nome();
        this.email = data.email();
        this.role = data.role();
    }

    public Colaborador(String matricula, String senha, String nome, String email, UserRole role) {
        this.matricula = matricula;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return matricula;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

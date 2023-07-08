package com.entrelinhas.apiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
  Perfil findByUsuarioEmailAndUsuarioSenha(String email, String senha);
};

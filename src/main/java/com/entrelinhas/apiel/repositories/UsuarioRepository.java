package com.entrelinhas.apiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByEmail(String email);
  boolean existsByEmail(String email);
};
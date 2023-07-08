package com.entrelinhas.apiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.Conquista;

public interface ConquistaRepository extends JpaRepository<Conquista, Long> {
  List<Conquista> findByUsuarioIdUsuario(Long usuario);
};

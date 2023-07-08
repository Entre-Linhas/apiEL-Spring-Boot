package com.entrelinhas.apiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.RedesSociais;

public interface RedesSociaisRepository extends JpaRepository<RedesSociais, Long> {
  List<RedesSociais> findByUsuarioIdUsuario(Long usuario);
};

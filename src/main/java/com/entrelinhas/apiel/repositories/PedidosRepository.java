package com.entrelinhas.apiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrelinhas.apiel.models.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
  List<Pedidos> findByUsuarioIdUsuario(Long usuario);
};

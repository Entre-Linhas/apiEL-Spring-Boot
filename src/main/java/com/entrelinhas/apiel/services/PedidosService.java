package com.entrelinhas.apiel.services;

import com.entrelinhas.apiel.models.Pedidos;
import com.entrelinhas.apiel.models.Status;
import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.repositories.PedidosRepository;
import com.entrelinhas.apiel.repositories.StatusRepository;
import com.entrelinhas.apiel.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {

  private final PedidosRepository pedidosRepository;
  private final UsuarioRepository usuarioRepository;
  private final StatusRepository statusRepository;

  public PedidosService(
    PedidosRepository pedidosRepository,
    UsuarioRepository usuarioRepository,
    StatusRepository statusRepository
  ) {
    this.pedidosRepository = pedidosRepository;
    this.usuarioRepository = usuarioRepository;
    this.statusRepository = statusRepository;
  }

  public Pedidos obterPedidoPorId(Long id) {
    return pedidosRepository.findById(id).orElse(null);
  }

  

  public List<Pedidos> obterTodosPedidos() {
    return pedidosRepository.findAll();
  }

  public Pedidos atualizarPedido(Pedidos pedido) {
    return pedidosRepository.save(pedido);
  }

  public void excluirPedido(Long id) {
    pedidosRepository.deleteById(id);
  }

  public List<Pedidos> obterPedidosPorUsuario(Long idUsuario) {
    return pedidosRepository.findByUsuarioIdUsuario(idUsuario);
  }

  public Pedidos criarPedido(Pedidos pedidos) {
    Pedidos pedido = new Pedidos();
    pedido.setDate(pedidos.getDate());
    pedido.setTitle(pedidos.getTitle());
    pedido.setDescription(pedidos.getDescription());
    pedido.setNome(pedidos.getNome());
    pedido.setQuantidade(pedidos.getQuantidade());
    pedido.setPrice(pedidos.getPrice());
    pedido.setEstado(pedidos.getEstado());

    if (pedidos.getUsuario() != null) {
      Optional<Usuario> usuarioOptional = usuarioRepository.findById(
        pedidos.getUsuario().getIdUsuario()
      );
      if (usuarioOptional.isPresent()) {
        pedido.setUsuario(usuarioOptional.get());
      } else {
        throw new RuntimeException(
          "Usuário não encontrado com o ID: " +
          pedidos.getUsuario().getIdUsuario()
        );
      }
    }
    if (pedidos.getStatus() != null) {
      Optional<Status> statusOptional = statusRepository.findById(
        pedidos.getUsuario().getIdUsuario()
      );
      if (statusOptional.isPresent()) {
        Status status = statusOptional.get();
        pedido.setStatus(status);
      } else {
        throw new RuntimeException(
          "Status não encontrado com o ID: " +
          pedidos.getUsuario().getIdUsuario()
        );
      }
    }

    return pedidosRepository.save(pedido);
  }
  
  public Pedidos alterarPedido(Pedidos boRyPedido, Long idPedido) {
    Optional<Pedidos> persistPedidos = pedidosRepository.findById(idPedido);
    if (persistPedidos.isPresent()) {
      Pedidos pedidosPersistente = persistPedidos.get();

      if (boRyPedido.getEstado() != null) {
        pedidosPersistente.setEstado(boRyPedido.getEstado());
      }
      if (boRyPedido.getDescription() != null) {
        pedidosPersistente.setDescription(boRyPedido.getDescription());
      }
      if (boRyPedido.getPrice() != null) {
        pedidosPersistente.setPrice(boRyPedido.getPrice());
      }
      if (boRyPedido.getDate() != null) {
        pedidosPersistente.setDate(boRyPedido.getDate());
      }
      if (boRyPedido.getQuantidade() != null) {
        pedidosPersistente.setQuantidade(boRyPedido.getQuantidade());
      }
      if (boRyPedido.getTitle() != null) {
        pedidosPersistente.setTitle(boRyPedido.getTitle());
      }
      if (boRyPedido.getNome() != null) {
        pedidosPersistente.setNome(boRyPedido.getNome());
      }
      return pedidosRepository.save(pedidosPersistente);
    } else {
      return null;
    }
  }
}

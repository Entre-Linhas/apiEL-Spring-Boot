package com.entrelinhas.apiel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Pedidos;
import com.entrelinhas.apiel.services.PedidosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidosController {

  private final PedidosService pedidosService;

  public PedidosController(PedidosService pedidosService) {
    this.pedidosService = pedidosService;
  }

  /* @GetMapping
public ResponseEntity<List<Pedidos>> obterTodosPedidos() {
    List<Pedidos> pedidos = pedidosService.obterTodosPedidos();
    if (!pedidos.isEmpty()) {
        return ResponseEntity.ok(pedidos);
    } else {
        return ResponseEntity.noContent().build();
    }
} */

@GetMapping("/{idUsuario}")
public ResponseEntity<List<Pedidos>> obterPedidosPorUsuario(/* @RequestParam("usuario")  */@PathVariable Long idUsuario) {
    List<Pedidos> pedidos = pedidosService.obterPedidosPorUsuario(idUsuario);
    return ResponseEntity.ok(pedidos);
}

@PutMapping("/{idPedido}")
public ResponseEntity<Pedidos> editarPedidosPorUsuario(@PathVariable Long idPedido, @Valid @RequestBody Pedidos corpoPedido) {
    Pedidos pedidosEditado = pedidosService.alterarPedido(corpoPedido, idPedido);
    if (pedidosEditado != null) {
        return ResponseEntity.ok(pedidosEditado);
    } else {
        return ResponseEntity.noContent().build();
    }
}
  

  @PostMapping
  public ResponseEntity<Pedidos> criarPedido( 
    @Valid @RequestBody Pedidos pedidos
  ) {
    if (pedidos != null) {
      Pedidos pedidosAtualizado = pedidosService.criarPedido( pedidos);
    
      return ResponseEntity.ok(pedidosAtualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
    pedidosService.excluirPedido(id);
    return ResponseEntity.noContent().build();
  }
}

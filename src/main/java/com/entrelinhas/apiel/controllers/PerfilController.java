package com.entrelinhas.apiel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Perfil;
import com.entrelinhas.apiel.services.PerfilService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/perfis")
@CrossOrigin(origins = "*")
public class PerfilController {

  private final PerfilService perfilService;

  public PerfilController(PerfilService perfilService) {
    this.perfilService = perfilService;
  }

  /* @PutMapping("/{id}")
  public ResponseEntity<Perfil> atualizarPerfil(
    @PathVariable Long id,
    @Valid @RequestBody Perfil perfil
  ) {
    
    Perfil perfilExistente = perfilService.obterPerfilPorId(id);
    if (perfilExistente != null) {
      Perfil perfilAtualizado = perfilService.atualizarPerfil(perfil);
      return ResponseEntity.ok(perfilAtualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  } */

  @PutMapping("/{id}")
  public ResponseEntity<Perfil> atualizarPerfil(
    @PathVariable Long id, /* // tudo oque esta no id */
    @Valid @RequestBody Perfil perfil /* // tudo oque foi tentado alterar */
  ) {
    Perfil perfilAtualizado = perfilService.atualizarPerfil(id, perfil);

    if (perfilAtualizado != null) {

      Long novaTrilhaId = perfil.getTrilhas().getId();
      perfilService.atualizarFKNaTabelaPerfil(id, novaTrilhaId);
      
      return ResponseEntity.ok(perfilAtualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Perfil>> obterTodosPerfisControl() {
    List<Perfil> perfisRes = perfilService.obterTodosPerfis();
    if (!perfisRes.isEmpty()) {
      return ResponseEntity.ok(perfisRes);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Perfil> obterUsuarioPorId(@PathVariable Long id) {
    Perfil perfil = perfilService.obterUsuarioPorId(id);
    if (perfil != null) {
      return ResponseEntity.ok(perfil);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{perfilId}/pedidos")
    public ResponseEntity<Void> adicionarPedidosEPrecificacoes(@PathVariable Long perfilId, @RequestBody Perfil pedido) {
        perfilService.adicionarPedidoEPrecificacao(perfilId, pedido);
        return ResponseEntity.ok().build();
    }
}

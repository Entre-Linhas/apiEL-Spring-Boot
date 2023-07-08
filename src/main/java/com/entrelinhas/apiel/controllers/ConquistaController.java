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

import com.entrelinhas.apiel.models.Conquista;
import com.entrelinhas.apiel.services.ConquistaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/conquista")
@CrossOrigin(origins = "*")
public class ConquistaController {

  private final ConquistaService conquistaService;

  public ConquistaController(ConquistaService conquistaService) {
    this.conquistaService = conquistaService;
  }

  @GetMapping("/{idconquista}")
  public ResponseEntity<List<Conquista>> obterConquistaPorUsuario(
    @PathVariable Long idconquista
  ) {
    List<Conquista> conquistas = conquistaService.obterConquistaPorUsuario(
      idconquista
    );
    return ResponseEntity.ok(conquistas);
  }

  @PutMapping("/{idconquista}")
  public ResponseEntity<Conquista> editarConquistaPorUsuario(
    @PathVariable Long idconquista,
    @Valid @RequestBody Conquista corpoEdicao
  ) {
    Conquista conquistaEditada = conquistaService.alterarConquista(
      corpoEdicao,
      idconquista
    );
    if (conquistaEditada != null) {
      return ResponseEntity.ok(conquistaEditada);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  @PostMapping
  public ResponseEntity<Conquista> criarConquista(
    @Valid @RequestBody Conquista redesSociais
  ) {
    if (redesSociais != null) {
      Conquista conquistaAtualizada = conquistaService.criarConquistas(
        redesSociais
      );

      return ResponseEntity.ok(conquistaAtualizada);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirConquistas(@PathVariable Long id) {
    conquistaService.excluirConquista(id);
    return ResponseEntity.noContent().build();
  }
}

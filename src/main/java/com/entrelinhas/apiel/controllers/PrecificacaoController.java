package com.entrelinhas.apiel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Precificacao;
import com.entrelinhas.apiel.services.PrecificacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/precificacao")
@CrossOrigin(origins = "*")
public class PrecificacaoController {
  private final PrecificacaoService precificacaoService;

  public PrecificacaoController(PrecificacaoService precificacaoService) {
    this.precificacaoService = precificacaoService;
  }

  @GetMapping
public ResponseEntity<List<Precificacao>> obterTodasPrecificacao() {
    List<Precificacao> precificacao = precificacaoService.obterTodasPrecificacao();
    if (!precificacao.isEmpty()) {
        return ResponseEntity.ok(precificacao);
    } else {
        return ResponseEntity.noContent().build();
    }
}

  @GetMapping("/{id}")
  public ResponseEntity<Precificacao> obterPrecificacaoPorId(@PathVariable Long id) {
    Precificacao precificacao = precificacaoService.obterPrecificacaoPorId(id);
    if (precificacao != null) {
      return ResponseEntity.ok(precificacao);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{id}")
  public ResponseEntity<Precificacao> criarPrecificacao(
    @PathVariable Long id,
    @Valid @RequestBody Precificacao precificacao
  ) {
    if (precificacao != null) {
      Precificacao precificacaoAtualizado = precificacaoService.criarPrecificacao(id, precificacao);
    
      return ResponseEntity.ok(precificacaoAtualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

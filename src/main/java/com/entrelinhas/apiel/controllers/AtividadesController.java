package com.entrelinhas.apiel.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Atividades;
import com.entrelinhas.apiel.services.AtividadesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/atividades")
@CrossOrigin(origins = "*")
public class AtividadesController {

  private final AtividadesService atividadesService;

  public AtividadesController(AtividadesService atividadesService) {
    this.atividadesService = atividadesService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Atividades> obterAtividadesPorId(@PathVariable Long id) {
    Atividades atividades = atividadesService.obterAtividadesPorId(id);
    if (atividades != null) {
      return ResponseEntity.ok(atividades);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  @PutMapping("/{id}")
  public ResponseEntity<Atividades> atualizarAtividades(
    @PathVariable Long id,
    @Valid @RequestBody Atividades atividades
  ) {
    
    Atividades atividadesAtualizado = atividadesService.atualizarAtividades(id, atividades);

    if (atividadesAtualizado != null) {

      /* // Conteudo
      if (atividades.getConteudo() != null) {
      Long novoConteudoId = atividadesAtualizado.getConteudo().getIdConteudo();
      atividadesService.atualizarFKAtividadeConteudo(id, novoConteudoId);
      }
      
      // Materia
      if (atividades.getMateria() != null) {
      Long novaMateriaId = atividades.getMateria().getIdMateria();
      atividadesService.atualizarFKAtividadeMateria(id, novaMateriaId);
}

      // Pratica
      if (atividades.getPratica() != null) {
      Long novaPraticaId = atividades.getPratica().getIdPratica();
      atividadesService.atualizarFKAtividadePratica(id, novaPraticaId);
}

      // Dica
      if (atividades.getDica() != null) {
      Long novaDicaId = atividades.getDica().getIdDica();
      atividadesService.atualizarFKAtividadeDica(id, novaDicaId);
      } */
      
      return ResponseEntity.ok(atividadesAtualizado);
    } else {
      return ResponseEntity.ok(null);
    }
  }
}

package com.entrelinhas.apiel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Pratica;
import com.entrelinhas.apiel.services.PraticaService;

@RestController
@RequestMapping("/pratica")
@CrossOrigin(origins = "*")
public class PraticaController {
  private final PraticaService praticaService;

  public PraticaController(PraticaService praticaService) {
    this.praticaService = praticaService; 
  }

  @GetMapping
  public ResponseEntity<List<Pratica>> obterTodasPraticas() {
    List<Pratica> praticaRes = praticaService.obterTodasPraticas();
    if (!praticaRes.isEmpty()) {
      return ResponseEntity.ok(praticaRes);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pratica> obterPraticaPorId(@PathVariable Long id) {
    Pratica pratica = praticaService.obterPraticaPorId(id);
    if (pratica != null) {
      return ResponseEntity.ok(pratica);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

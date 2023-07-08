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

import com.entrelinhas.apiel.models.RedesSociais;
import com.entrelinhas.apiel.services.RedesSociaisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/redesocial")
@CrossOrigin(origins = "*")
public class RedesSociaisController {
  private final RedesSociaisService redesSociaisService;

  public RedesSociaisController(RedesSociaisService redesSociaisService) {
    this.redesSociaisService = redesSociaisService;
  }

  @GetMapping("/{idsocial}")
public ResponseEntity<List<RedesSociais>> obterRedesSociaisPorUsuario(/* @RequestParam("usuario")  */@PathVariable Long idsocial) {
    List<RedesSociais> redesSociais = redesSociaisService.obterRedesSociaisPorUsuario(idsocial);
    return ResponseEntity.ok(redesSociais);
}

@PutMapping("/{idsocial}")
public ResponseEntity<RedesSociais> editarRedesSociaisPorUsuario(@PathVariable Long idsocial, @Valid @RequestBody RedesSociais corpoEdicao) {
    RedesSociais redesSociaisEditada = redesSociaisService.alterarRedeSocial(corpoEdicao, idsocial);
    if (redesSociaisEditada != null) {
        return ResponseEntity.ok(redesSociaisEditada);
    } else {
        return ResponseEntity.noContent().build();
    }
}

  @PostMapping
  public ResponseEntity<RedesSociais> criarRedeSocial( 
    @Valid @RequestBody RedesSociais redesSociais
  ) {
    if (redesSociais != null) {
      RedesSociais redesSociaisAtualizada = redesSociaisService.criarRedesSociais(redesSociais);
    
      return ResponseEntity.ok(redesSociaisAtualizada);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirRedeSocial(@PathVariable Long id) {
    redesSociaisService.excluirRedesSociais(id);
    return ResponseEntity.noContent().build();
  }
}

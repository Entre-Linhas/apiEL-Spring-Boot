package com.entrelinhas.apiel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrelinhas.apiel.models.Ferramentas;
import com.entrelinhas.apiel.services.FerramentasService;

/* import com.entrelinhas.apiel.services.FerramentasService; */

@RestController
@RequestMapping("/api/ferramentas")
@CrossOrigin(origins = "*")
public class FerramentasController {

  private final FerramentasService ferramentasService;

    @Autowired
    public FerramentasController(FerramentasService ferramentasService) {
        this.ferramentasService = ferramentasService;
    }

    @GetMapping("/{id}")
    public Ferramentas getFerramentas(@PathVariable("id") Long id) {
        return ferramentasService.obterFerramentasPorId(id);
    }
  
  /* private final FerramentasService ferramentasService;

  public FerramentasController(FerramentasService ferramentasService) {
    this.ferramentasService = ferramentasService;
  } */

  
}

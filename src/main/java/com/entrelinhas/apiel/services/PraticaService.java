package com.entrelinhas.apiel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Pratica;
import com.entrelinhas.apiel.repositories.PraticaRepository;

@Service
public class PraticaService {
    private final PraticaRepository praticaRepository;

    public PraticaService(PraticaRepository praticaRepository) {
        this.praticaRepository = praticaRepository;
    }

    public Pratica obterPraticaPorId(Long id) {
        return praticaRepository.findById(id).orElse(null);
    }

    public Pratica criarPratica(Pratica pratica) {
        return praticaRepository.save(pratica);
    }

    public Pratica atualizarPratica(Pratica pratica) {
        return praticaRepository.save(pratica);
    }

    public void excluirPratica(Long id) {
        praticaRepository.deleteById(id);
    }

    public List<Pratica> obterTodasPraticas() {
    return praticaRepository.findAll();
    }
}

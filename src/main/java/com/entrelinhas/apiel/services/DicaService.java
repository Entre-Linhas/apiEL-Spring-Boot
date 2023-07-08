package com.entrelinhas.apiel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Dica;
import com.entrelinhas.apiel.repositories.DicaRepository;

@Service
public class DicaService {
    private final DicaRepository dicaRepository;

    public DicaService(DicaRepository dicaRepository) {
        this.dicaRepository = dicaRepository;
    }

    public Dica obterDicaPorId(Long id) {
        return dicaRepository.findById(id).orElse(null);
    }

    public Dica criarDica(Dica dica) {
        return dicaRepository.save(dica);
    }

    public Dica atualizarDica(Dica dica) {
        return dicaRepository.save(dica);
    }

    public void excluirDica(Long id) {
        dicaRepository.deleteById(id);
    }

    public List<Dica> obterTodasDicas() {
    return dicaRepository.findAll();
    }
}

package com.entrelinhas.apiel.services;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Plano;
import com.entrelinhas.apiel.repositories.PlanoRepository;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano obterPlanoPorId(Long id) {
        return planoRepository.findById(id).orElse(null);
    }

    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano atualizarPlano(Plano plano) {
        return planoRepository.save(plano);
    }

    public void excluirPlano(Long id) {
        planoRepository.deleteById(id);
    }
}

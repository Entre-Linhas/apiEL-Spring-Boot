package com.entrelinhas.apiel.services;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Propriedades;
import com.entrelinhas.apiel.repositories.PropriedadesRepository;

@Service
public class PropriedadesService {
    private final PropriedadesRepository propriedadesRepository;

    public PropriedadesService(PropriedadesRepository propriedadesRepository) {
        this.propriedadesRepository = propriedadesRepository;
    }

    public Propriedades obterPropriedadesPorId(Long id) {
        return propriedadesRepository.findById(id).orElse(null);
    }

    public Propriedades criarPropriedades(Propriedades propriedades) {
        return propriedadesRepository.save(propriedades);
    }

    public Propriedades atualizarPropriedades(Propriedades propriedades) {
        return propriedadesRepository.save(propriedades);
    }

    public void excluirPropriedades(Long id) {
        propriedadesRepository.deleteById(id);
    }
}

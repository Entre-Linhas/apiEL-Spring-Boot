package com.entrelinhas.apiel.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Perfil;
import com.entrelinhas.apiel.models.Trilhas;
import com.entrelinhas.apiel.repositories.TrilhasRepository;

@Service
public class TrilhasService {
    private final TrilhasRepository trilhasRepository;
    private final AtividadesService atividadesService;

    public TrilhasService(TrilhasRepository trilhasRepository, AtividadesService atividadesService) {
        this.trilhasRepository = trilhasRepository;
        this.atividadesService = atividadesService;
    }

    public Trilhas obterTrilhasPorId(Long id) {
        return trilhasRepository.findById(id).orElse(null);
    }

    public Trilhas criarTrilhas(Trilhas trilhas) {
        return trilhasRepository.save(trilhas);
    }

    public Trilhas atualizarTrilhas(Trilhas trilhas) {
        return trilhasRepository.save(trilhas);
    }

    public void excluirTrilhas(Long id) {
        trilhasRepository.deleteById(id);
    }

    public void criarTrilhaParaPerfil(Perfil perfil) {
    // Lógica para criar o trilhas e associá-lo ao usuário
    Trilhas trilha = new Trilhas();
    trilha.setTitulo("Trilha educacional");
    trilha.setStatus("Iniciante");
    trilha.setDataCriacao(LocalDateTime.now());
    trilha.setNivelMinimo(0);
    
    Trilhas newtrilha = trilhasRepository.save(trilha);

    perfil.setTrilhas(newtrilha);
    
    atividadesService.criarAtividadesParaTrilha(newtrilha);
  }
}

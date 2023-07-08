package com.entrelinhas.apiel.services;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Conteudo;
import com.entrelinhas.apiel.repositories.ConteudoRepository;

@Service
public class ConteudoService {
    private final ConteudoRepository conteudoRepository;

    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    public Conteudo obterConteudoPorId(Long id) {
        return conteudoRepository.findById(id).orElse(null);
    }

    public Conteudo criarConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public Conteudo atualizarConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public void excluirConteudo(Long id) {
        conteudoRepository.deleteById(id);
    }
}

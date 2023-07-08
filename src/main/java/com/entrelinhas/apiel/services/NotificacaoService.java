package com.entrelinhas.apiel.services;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Notificacao;
import com.entrelinhas.apiel.repositories.NotificacaoRepository;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public Notificacao obterNotificacaoPorId(Long id) {
        return notificacaoRepository.findById(id).orElse(null);
    }

    public Notificacao criarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao atualizarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public void excluirNotificacao(Long id) {
        notificacaoRepository.deleteById(id);
    }
}

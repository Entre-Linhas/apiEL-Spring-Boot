package com.entrelinhas.apiel.services;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Status;
import com.entrelinhas.apiel.repositories.StatusRepository;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status obterStatusPorId(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    public Status criarStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status atualizarStatus(Status status) {
        return statusRepository.save(status);
    }

    public void excluirStatus(Long id) {
        statusRepository.deleteById(id);
    }
}

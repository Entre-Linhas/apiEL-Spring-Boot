package com.entrelinhas.apiel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Materia;
import com.entrelinhas.apiel.repositories.MateriaRepository;

@Service
public class MateriaService {
    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Materia obterMateriaPorId(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public Materia criarMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia atualizarMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void excluirMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    public List<Materia> obterTodasMaterias() {
    return materiaRepository.findAll();
  }
}

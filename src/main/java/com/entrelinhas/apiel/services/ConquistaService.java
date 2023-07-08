package com.entrelinhas.apiel.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Conquista;
import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.repositories.ConquistaRepository;
import com.entrelinhas.apiel.repositories.UsuarioRepository;

@Service
public class ConquistaService {
  private final ConquistaRepository conquistaRepository;
  private final UsuarioRepository usuarioRepository;

    public ConquistaService(ConquistaRepository conquistaRepository, UsuarioRepository usuarioRepository) {
        this.conquistaRepository = conquistaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Conquista obterConquistaPorId(Long id) {
        return conquistaRepository.findById(id).orElse(null);
    }

    /* public Conquista criarConquista(Conquista conquista) {
        return conquistaRepository.save(conquista);
    } */

    public Conquista atualizarConquista(Conquista conquista) {
        return conquistaRepository.save(conquista);
    }

    public void excluirConquista(Long id) {
        conquistaRepository.deleteById(id);
    }

    public List<Conquista> obterConquistaPorUsuario(Long idUsuario) {
    return conquistaRepository.findByUsuarioIdUsuario(idUsuario);
  }

  public Conquista criarConquistas(Conquista conquistas) {
    Conquista conquista = new Conquista();
    conquista.setNome(conquistas.getNome());
    conquista.setDataConquista(conquistas.getDataConquista());

    if (conquistas.getUsuario() != null) {
      Optional<Usuario> usuarioOptional = usuarioRepository.findById(
        conquistas.getUsuario().getIdUsuario()
      );
      if (usuarioOptional.isPresent()) {
        conquista.setUsuario(usuarioOptional.get());
      } else {
        throw new RuntimeException(
          "Usuário não encontrado com o ID: " +
          conquistas.getUsuario().getIdUsuario()
        );
      }
    }

    return conquistaRepository.save(conquista);
  }
  
  public Conquista alterarConquista(Conquista boRyPedido, Long idConquista) {
    Optional<Conquista> persistConquista = conquistaRepository.findById(idConquista);
    if (persistConquista.isPresent()) {
      Conquista conquistasPersistente = persistConquista.get();

      if (boRyPedido.getNome() != null) {
        conquistasPersistente.setNome(boRyPedido.getNome());
      }
      if (boRyPedido.getDataConquista() != null) {
        conquistasPersistente.setDataConquista(boRyPedido.getDataConquista());
      }
      return conquistaRepository.save(conquistasPersistente);
    } else {
      return null;
    }
  }    
}

package com.entrelinhas.apiel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.RedesSociais;
import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.repositories.RedesSociaisRepository;
import com.entrelinhas.apiel.repositories.UsuarioRepository;

@Service
public class RedesSociaisService {
    private final RedesSociaisRepository redesSociaisRepository;
    private final UsuarioRepository usuarioRepository;

    public RedesSociaisService(RedesSociaisRepository redesSociaisRepository, UsuarioRepository usuarioRepository) {
        this.redesSociaisRepository = redesSociaisRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public RedesSociais obterRedesSociaisPorId(Long id) {
        return redesSociaisRepository.findById(id).orElse(null);
    }

    public RedesSociais criarRedesSociais(RedesSociais redesSociais) {
        return redesSociaisRepository.save(redesSociais);
    }

    public RedesSociais atualizarRedesSociais(RedesSociais redesSociais) {
        return redesSociaisRepository.save(redesSociais);
    }

    public void excluirRedesSociais(Long id) {
        redesSociaisRepository.deleteById(id);
    }

    public List<RedesSociais> obterRedesSociaisPorUsuario(Long idUsuario) {
    return redesSociaisRepository.findByUsuarioIdUsuario(idUsuario);
  }

  public RedesSociais criarRedeSocial(RedesSociais redesSociais) {
    RedesSociais redeSocial = new RedesSociais();
    redeSocial.setLink(redesSociais.getLink());

    if (redesSociais.getUsuario() != null) {
      Optional<Usuario> usuarioOptional = usuarioRepository.findById(
        redesSociais.getUsuario().getIdUsuario()
      );
      if (usuarioOptional.isPresent()) {
        redeSocial.setUsuario(usuarioOptional.get());
      } else {
        throw new RuntimeException(
          "Usuário não encontrado com o ID: " +
          redesSociais.getUsuario().getIdUsuario()
        );
      }
    }

    return redesSociaisRepository.save(redeSocial);
  }
  
  public RedesSociais alterarRedeSocial(RedesSociais boRyRedeSocial, Long idRedeSocial) {
    Optional<RedesSociais> persistRedesSociais = redesSociaisRepository.findById(idRedeSocial);
    if (persistRedesSociais.isPresent()) {
      RedesSociais redesSociaisPersistente = persistRedesSociais.get();

      if (boRyRedeSocial.getLink() != null) {
        redesSociaisPersistente.setLink(boRyRedeSocial.getLink());
      }
      return redesSociaisRepository.save(redesSociaisPersistente);
    } else {
      return null;
    }
  }
}

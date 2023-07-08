package com.entrelinhas.apiel.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrelinhas.apiel.exceptions.CustomException;
import com.entrelinhas.apiel.models.Ferramentas;
import com.entrelinhas.apiel.models.PayloadLogin;
import com.entrelinhas.apiel.models.Pedidos;
import com.entrelinhas.apiel.models.Perfil;
import com.entrelinhas.apiel.models.PerfilDto;
import com.entrelinhas.apiel.models.Precificacao;
import com.entrelinhas.apiel.models.Trilhas;
import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.repositories.PerfilRepository;
import com.entrelinhas.apiel.repositories.TrilhasRepository;

@Service
public class PerfilService {

  private final TrilhasRepository trilhasRepository;
  private final PerfilRepository perfilRepository;
  private final TrilhasService trilhasService;
  private final PedidosService pedidosService;
  private final PrecificacaoService precificacaoService;
  private final FerramentasService ferramentasService;

  public PerfilService(
    PerfilRepository perfilRepository,
    TrilhasRepository trilhasRepository, TrilhasService trilhasService, PedidosService pedidosService, PrecificacaoService precificacaoService, FerramentasService ferramentasService
  ) {
    this.perfilRepository = perfilRepository;
    this.trilhasRepository = trilhasRepository;
    this.trilhasService = trilhasService;
    this.pedidosService = pedidosService;
    this.precificacaoService = precificacaoService;
    this.ferramentasService = ferramentasService;
  }

  public Perfil obterPerfilPorId(Long id) {
    return perfilRepository.findById(id).orElse(null);
  }

  @Transactional
  public Perfil criarPerfil(Perfil perfil) {
    return perfilRepository.save(perfil);
  }

@Transactional
public Perfil atualizarPerfil(Long id, Perfil perfil) {
  Optional <Perfil> persistedPerfil = perfilRepository.findById(id);
  if (!persistedPerfil.isEmpty()) {
    perfil.setNivel(perfil.getNivel());
    perfil.setConquista(perfil.getConquista());
    perfil.setPontuacoes(perfil.getPontuacoes());
    perfil.setServico(perfil.getServico());
    perfil.setDaily(perfil.getDaily());
    perfil.setCombo(perfil.getCombo());
    perfil.setMaxCombo(perfil.getMaxCombo());
    perfil.setFoto(perfil.getFoto());
    perfil.setProgresso(perfil.getProgresso());
    
    perfil.setIdPerfil(id);
    
    /* Trilhas trilhas = perfil.getTrilhas();
    if (trilhas != null) {
      // Verifica se a trilha já está persistida no banco de dados
      if (trilhas.getId() == null || !trilhasRepository.existsById(trilhas.getId())) {
        trilhas = trilhasRepository.save(trilhas);
      }
      perfil.setTrilhas(trilhas);
    } */

    return perfilRepository.save(perfil);
  }
  
  return null; // Adicione um retorno caso o perfil seja nulo
}

  public void excluirPerfil(Long id) {
    perfilRepository.deleteById(id);
  }

  @Transactional
  public void criarPerfilParaUsuario(Usuario novoUsuario) {
    // Lógica para criar o perfil e associá-lo ao usuário
    Perfil perfil = new Perfil();
    perfil.setNivel(0);
    perfil.setConquista(0);
    perfil.setPontuacoes(0);
    perfil.setServico(null);
    perfil.setDaily(LocalDate.now());
    perfil.setCombo(0);
    perfil.setMaxCombo(10);
    perfil.setFoto("/19.png");
    
    perfil.setUsuario(novoUsuario);

    // cria o perfil
    Perfil newPerfil = perfilRepository.save(perfil);
    // cria apenas a conexão com o perfil, FK
    trilhasService.criarTrilhaParaPerfil(newPerfil);

    ferramentasService.criarFerramentasParaPerfil(newPerfil);
  }

  public List<Perfil> obterTodosPerfis() {
    return perfilRepository.findAll();
  }

  public Perfil obterUsuarioPorId(Long id) {
    return perfilRepository.findById(id).orElse(null);
  }

  public void atualizarFKNaTabelaPerfil(Long antigoIdPerfilAlvo, Long novoIdTrocaTrilha) {
    Perfil perfil = perfilRepository.findById(antigoIdPerfilAlvo).orElse(null);
    Trilhas trilha = trilhasRepository.findById(novoIdTrocaTrilha).orElse(null);

    if (perfil != null && trilha != null) {
      perfil.setTrilhas(trilha);
      perfilRepository.save(perfil);
    }
  }

  public PerfilDto perfilLogin(PayloadLogin payload) {
    Perfil perfil = perfilRepository.findByUsuarioEmailAndUsuarioSenha(payload.getEmail(), payload.getSenha());
    if (perfil == null) {
      throw new CustomException("Email ou Senha incorretos", HttpStatus.BAD_REQUEST);
    }
    return new PerfilDto(perfil);
  }

  public void adicionarPedidoEPrecificacao(Long perfilId, Perfil pedidoEprecificacao) {
        Perfil perfil = perfilRepository.findById(perfilId).orElse(null);

        Ferramentas ferramenta = perfil.getFerramentas();

        if (ferramenta.getPedidos() != null) {
          Pedidos pedidos = ferramenta.getPedidos();
          Pedidos novoPedido = pedidosService.criarPedido(pedidos);
          ferramenta.setPedidos(novoPedido);
        }
        if (ferramenta.getPrecificacao() != null && ferramenta.getPedidos() != null) {
          Precificacao precificacao = ferramenta.getPrecificacao();
          Precificacao novoPrecificacao = precificacaoService.criarPrecificacao(ferramenta.getPedidos().getId(), precificacao);
          ferramenta.setPrecificacao(novoPrecificacao);
        }

        perfilRepository.save(perfil);
    }
}

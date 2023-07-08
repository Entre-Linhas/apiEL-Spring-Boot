package com.entrelinhas.apiel.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entrelinhas.apiel.models.Atividades;
import com.entrelinhas.apiel.models.Conteudo;
import com.entrelinhas.apiel.models.Dica;
import com.entrelinhas.apiel.models.Materia;
import com.entrelinhas.apiel.models.Pratica;
import com.entrelinhas.apiel.models.Trilhas;
import com.entrelinhas.apiel.repositories.AtividadesRepository;
import com.entrelinhas.apiel.repositories.ConteudoRepository;
import com.entrelinhas.apiel.repositories.DicaRepository;
import com.entrelinhas.apiel.repositories.MateriaRepository;
import com.entrelinhas.apiel.repositories.PraticaRepository;

@Service
public class AtividadesService {

  private final AtividadesRepository atividadesRepository;

  private final ConteudoRepository conteudoRepository;
  private final MateriaRepository materiaRepository;
  private final PraticaRepository praticaRepository;
  private final DicaRepository dicaRepository;

  public AtividadesService(
    AtividadesRepository atividadesRepository,
    ConteudoRepository conteudoRepository,
    MateriaRepository materiaRepository,
    PraticaRepository praticaRepository,
    DicaRepository dicaRepository
  ) {
    this.atividadesRepository = atividadesRepository;

    this.conteudoRepository = conteudoRepository;
    this.materiaRepository = materiaRepository;
    this.praticaRepository = praticaRepository;
    this.dicaRepository = dicaRepository;
  }

  public Atividades obterAtividadesPorId(Long id) {
    return atividadesRepository.findById(id).orElse(null);
  }

  public Atividades criarAtividades(Atividades atividades) {
    return atividadesRepository.save(atividades);
  }

  public Atividades atualizarAtividades(Long id, Atividades atividades) {
    Optional <Atividades> persistAtividade = atividadesRepository.findById(id);
    if (persistAtividade.isPresent()) {
        Atividades atividadePersistente = persistAtividade.get();
        
        if (atividades.getNomeAtividade() != null) {
            atividadePersistente.setNomeAtividade(atividades.getNomeAtividade());
        }
        if (atividades.getProgresso() != null) {
            atividadePersistente.setProgresso(atividades.getProgresso());
        }
        if (atividades.getStatus() != null) {
            atividadePersistente.setStatus(atividades.getStatus());
        }
        if (atividades.getMateria() != null) {
            /* Optional <Materia> persistMateria = materiaRepository.findById(atividades.getMateria().getIdMateria()); */
            Long novaMateria = atividades.getMateria().getIdMateria();
            Materia materiaPorID = materiaRepository.findById(novaMateria).orElse(null);
            atividadePersistente.setMateria(materiaPorID);
        }
        if (atividades.getPratica() != null) {
          Optional <Pratica> persistPratica = praticaRepository.findById(atividades.getPratica().getIdPratica());
            atividadePersistente.setPratica(persistPratica.get());
        }
        if (atividades.getDica() != null) {
          Optional <Dica> persistDica = dicaRepository.findById(atividades.getDica().getIdDica());
            atividadePersistente.setDica(persistDica.get());
        }
        
        return atividadesRepository.save(atividadePersistente);
    }
    return null;
  }

  // para setar conteudo na atividade - desnecessario os 3 de baixo tbm
  public void atualizarFKAtividadeConteudo(Long idAtividade, Long idConteudo) {
        Atividades atividades = atividadesRepository.findById(idAtividade).orElse(null);
        Conteudo conteudo = conteudoRepository.findById(idConteudo).orElse(null);
    
        if (atividades != null && conteudo != null) {
          atividades.setConteudo(conteudo);
          atividadesRepository.save(atividades);
        }
      }

  public void atualizarFKAtividadeMateria(
    Long idAtividade,
    Long novoIdTrocaMateria
  ) {
    Atividades atividades = atividadesRepository
      .findById(idAtividade)
      .orElse(null);
    Materia materia = materiaRepository
      .findById(novoIdTrocaMateria)
      .orElse(null);

    if (atividades != null && materia != null) {
      atividades.setMateria(materia);
      atividadesRepository.save(atividades);
    }
  }

  public void atualizarFKAtividadePratica(
    Long idAtividade,
    Long novoIdTrocaPratica
  ) {
    Atividades atividades = atividadesRepository
      .findById(idAtividade)
      .orElse(null);
    Pratica pratica = praticaRepository
      .findById(novoIdTrocaPratica)
      .orElse(null);

    if (atividades != null && pratica != null) {
      atividades.setPratica(pratica);
      atividadesRepository.save(atividades);
    }
  }

  public void atualizarFKAtividadeDica(
    Long idAtividade,
    Long novoIdTrocaDica
  ) {
    Atividades atividades = atividadesRepository
      .findById(idAtividade)
      .orElse(null);
    Dica dica = dicaRepository.findById(novoIdTrocaDica).orElse(null);

    if (atividades != null && dica != null) {
      atividades.setDica(dica);
      atividadesRepository.save(atividades);
    }
  }

  public void criarAtividadesParaTrilha(Trilhas trilha) {
    Atividades atividade = new Atividades();
    atividade.setNomeAtividade("Aula 1");
    atividade.setStatus("Estudando");
    atividade.setProgresso(0.1f);

    trilha.setAtividades(atividade);

    /* Materia materia = materiaRepository.findByTitulo("Título da Materia");
    Long idMateria = (materia != null) ? materia.getId() : null;
    atualizarFKAtividadeMateria(atividade.getIdAtividades(), 1L); */

    atividadesRepository.save(atividade);
  }

  public void excluirAtividades(Long id) {
    atividadesRepository.deleteById(id);
  }
}

package com.entrelinhas.apiel.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDto {

  public PerfilDto(Perfil profile) {
    this.setUsuario(new UsuarioDto(profile.getUsuario()));
    this.setCombo(profile.getCombo());
    this.setConquista(profile.getConquista());
    this.setDaily(profile.getDaily());
    this.setFerramentas(profile.getFerramentas());
    this.setFoto(profile.getFoto());
    this.setMaxCombo(profile.getMaxCombo());
    this.setNivel(profile.getNivel());
    this.setPontuacoes(profile.getPontuacoes());
    this.setProgresso(profile.getProgresso());
    this.setServico(profile.getServico());
    this.setTrilhas(profile.getTrilhas());
    this.setIdPerfil(profile.getIdPerfil());
  }

  private UsuarioDto usuario;
  private Long idPerfil;
  private Integer nivel;
  private Integer conquista;
  private Integer pontuacoes;
  private String servico;
  private LocalDate daily;
  private Integer combo;
  private Integer maxCombo;
  private Float progresso;
  private String foto;
  private Trilhas trilhas;
  private Ferramentas ferramentas;
}

package com.entrelinhas.apiel.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
/* import jakarta.persistence.ManyToOne; */
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Perfil.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Perfil {

  public static final String TABLE_NAME = "perfil";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_perfil", unique = true)
  private Long idPerfil;

  @Column(name = "nivel")
  private Integer nivel;

  @Column(name = "conquista")
  private Integer conquista;

  @Column(name = "pontuacoes")
  private Integer pontuacoes;

  @Column(name = "servico")
  private String servico;

  @Column(name = "daily")
  private LocalDate daily;

  @Column(name = "combo")
  private Integer combo;

  @Column(name = "max_combo")
  private Integer maxCombo;

  @Column(name = "progresso")
  private Float progresso;

  @Column(name = "foto")
  private String foto;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
  private Usuario usuario;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_trilhas", referencedColumnName = "id_trilhas")
  private Trilhas trilhas;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_ferramentas", referencedColumnName = "id_ferramentas")
  private Ferramentas ferramentas;
}

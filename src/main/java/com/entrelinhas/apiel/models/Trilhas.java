package com.entrelinhas.apiel.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = Trilhas.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trilhas {

  public static final String TABLE_NAME = "trilhas";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_trilhas", unique = true)
  private Long id;

  @Column(name = "titulo")
  private String titulo;

  @Column(name = "status")
  private String status;

  @Column(name = "data_criacao")
  private LocalDateTime  dataCriacao;

  @Column(name = "nivel_minimo", nullable = true)
  private Integer nivelMinimo;

  //Pai
  @OneToOne
  @JoinColumn(name = "id_atividades", referencedColumnName = "id_atividades")
  private Atividades atividades;

  //Pai
  @OneToOne
  @JoinColumn(name = "id_status", referencedColumnName = "id_status")
  private Status statusFk;

  //Filho
  @OneToOne(mappedBy = "trilhas", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private Perfil perfil;
}

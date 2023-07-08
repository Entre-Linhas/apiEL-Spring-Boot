package com.entrelinhas.apiel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Atividades.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividades {

  public static final String TABLE_NAME = "atividades";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_atividades", unique = true)
  private Long idAtividades;

  @Column(name = "nome_atividade")
  private String nomeAtividade;

  @Column(name = "status")
  private String status;

  @Column(name = "progresso")
  private Float progresso;

  //Pai - desnecessario
  @ManyToOne
  @JoinColumn(name = "id_conteudo", referencedColumnName = "id_conteudo")
  private Conteudo conteudo; // conteudo fk

  //Pai
  @ManyToOne
  @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
  private Materia materia;
  
  //Pai
  @ManyToOne
  @JoinColumn(name = "id_pratica", referencedColumnName = "id_pratica")
  private Pratica pratica;

  //Pai
  @ManyToOne
  @JoinColumn(name = "id_dica", referencedColumnName = "id_dica")
  private Dica dica;

  //Filho
  @OneToOne(mappedBy = "atividades", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private Trilhas trilhas;
}

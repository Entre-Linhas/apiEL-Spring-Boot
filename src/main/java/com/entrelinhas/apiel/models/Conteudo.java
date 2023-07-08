package com.entrelinhas.apiel.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
/* import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access; */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conteudo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conteudo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_conteudo", unique = true)
  private Long idConteudo;

  @Column(name = "perguntas", length = 255)
  private String perguntas;

  @Column(name = "respostas", length = 255)
  private String respostas;

  @Column(name = "propriedades")
  private Integer propriedades;

  @Column(name = "descricao", columnDefinition = "TEXT")
  private String descricao;

  /* @OneToMany(mappedBy = "conteudo")
    @JsonProperty(access = Access.READ_ONLY)
    private List<Atividades> atividade = new ArrayList<Atividades>(); */

  //Filho
  @OneToMany(mappedBy = "conteudo", cascade = CascadeType.PERSIST) // comteudo pega fk
  @JsonIgnore
  private List<Atividades> atividades;
}

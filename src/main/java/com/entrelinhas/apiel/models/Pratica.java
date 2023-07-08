package com.entrelinhas.apiel.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = Pratica.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pratica {

  public static final String TABLE_NAME = "pratica";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pratica", unique = true)
  private Long idPratica;

  @Column(name = "titulo_pag", length = 255, nullable = true)
  private String tituloPag;

  @Column(name = "subtitulo_pag", length = 255, nullable = true)
  private String img;

  @Column(name = "txt1", columnDefinition = "TEXT", nullable = true)
  private String txt1;

  @Column(name = "txt2", columnDefinition = "TEXT", nullable = true)
  private String txt2;
  
  @Column(name = "txt3", columnDefinition = "TEXT", nullable = true)
  private String txt3;

  @Column(name = "txt4", columnDefinition = "TEXT", nullable = true)
  private String txt4;

  //Filho
  @OneToMany(mappedBy = "pratica", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private List<Atividades> atividades;
}

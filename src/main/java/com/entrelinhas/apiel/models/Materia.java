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
@Table(name = Materia.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {

  public static final String TABLE_NAME = "materia";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_materia", unique = true)
  private Long idMateria;

  @Column(name = "titulo_pag", length = 255, nullable = true)
  private String tituloPag;

  @Column(name = "img", length = 255, nullable = true)
  private String img;

  @Column(name = "txt1", columnDefinition = "TEXT", nullable = true)
  private String txt1;

  @Column(name = "txt2", columnDefinition = "TEXT", nullable = true)
  private String txt2;
  
  @Column(name = "txt3", columnDefinition = "TEXT", nullable = true)
  private String txt3;

  //Filho
  @OneToMany(mappedBy = "materia", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private List<Atividades> atividades;
}

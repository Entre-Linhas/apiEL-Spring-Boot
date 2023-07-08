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
@Table(name = Dica.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dica {

  public static final String TABLE_NAME = "dica";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_dica", unique = true)
  private Long idDica;

  @Column(name = "titulo_pag", length = 255, nullable = true)
  private String tituloPag;

  @Column(name = "txt1", columnDefinition = "TEXT", nullable = true)
  private String txt1;

  @Column(name = "txt2", columnDefinition = "TEXT", nullable = true)
  private String txt2;
  
  @Column(name = "txt3", columnDefinition = "TEXT", nullable = true)
  private String txt3;

  @Column(name = "txt4", columnDefinition = "TEXT", nullable = true)
  private String txt4;

  @Column(name = "txt5", columnDefinition = "TEXT", nullable = true)
  private String txt5;

  @Column(name = "txt6", columnDefinition = "TEXT", nullable = true)
  private String txt6;

  @Column(name = "txt7", columnDefinition = "TEXT", nullable = true)
  private String txt7;

  @Column(name = "txt8", columnDefinition = "TEXT", nullable = true)
  private String txt8;

  //Filho
  @OneToMany(mappedBy = "dica", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private List<Atividades> atividades;
}

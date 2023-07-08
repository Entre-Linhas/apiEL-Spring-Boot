package com.entrelinhas.apiel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Status.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Status {
  public static final String TABLE_NAME = "status";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_status", unique = true)
  private Long id;

  @Column(name = "status_usuarios")
  private int statusUsuarios;

  @Column(name = "status_trilha")
  private int statusTrilha;

  @Column(name = "status_atividade")
  private int statusAtividade;

  // Filho
  @OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Usuario usuario;

  // Filho
  @OneToOne(mappedBy = "statusFk", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Trilhas trilhas;

  // Filho
  @OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Plano plano;

  // Filho
  @OneToOne(mappedBy = "status", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Pedidos pedidos;
}

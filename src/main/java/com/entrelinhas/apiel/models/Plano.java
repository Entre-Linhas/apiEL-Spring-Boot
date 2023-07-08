package com.entrelinhas.apiel.models;


import java.math.BigDecimal;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Plano.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Plano {
  public static final String TABLE_NAME = "plano";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_plano", unique = true)
  private Long idPlano;

  @Column(name = "nome", length = 255, nullable = false)
  @NotBlank
  @Size(min = 2, max = 255)
  private String nome;
  
  @Column(name = "descricao", length = 255, nullable = true, unique = true, columnDefinition = "TEXT")
  @NotBlank
  @Size(min = 2, max = 255)
  private String descricao;

  @Column(name = "preco", length = 255, nullable = true, unique = true)
  @NotBlank
  @Size(min = 2, max = 255)
  private BigDecimal preco;


  // Pai
  @OneToOne
  @JoinColumn(name = "id_status", referencedColumnName = "id_status")
  private Status status;

  // Filho
  @OneToOne(mappedBy = "plano", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Usuario usuario;
}

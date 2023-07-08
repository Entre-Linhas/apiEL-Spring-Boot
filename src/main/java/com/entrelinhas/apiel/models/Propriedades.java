package com.entrelinhas.apiel.models;

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
@Table(name = Propriedades.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Propriedades {

  public static final String TABLE_NAME = "propriedades";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_propriedades", unique = true)
  private Long id;

  @Column(name = "tipo_propriedade")
  private String tipoPropriedade;

  @Column(name = "valor_propriedade")
  private String valorPropriedade;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_ferramentas", referencedColumnName = "id_ferramentas")
  private Ferramentas ferramentas;
}

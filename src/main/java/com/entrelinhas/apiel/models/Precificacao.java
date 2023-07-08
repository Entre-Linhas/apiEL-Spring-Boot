package com.entrelinhas.apiel.models;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Precificacao.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Precificacao {

  public static final String TABLE_NAME = "precificacao";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_precificacao", unique = true)
  private Long id;

  @Column(name = "material")
  private String material;

  @Column(name = "preco")
  private BigDecimal preco;

  @Column(name = "quantidade")
  private Integer quantidade;

  @Column(name = "preco_total")
  private BigDecimal precoTotal;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_pedidos", referencedColumnName = "id_pedidos")
  private Pedidos pedidos;

  //Filho
  @OneToMany(mappedBy = "precificacao", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private List<Ferramentas> ferramentas;
}

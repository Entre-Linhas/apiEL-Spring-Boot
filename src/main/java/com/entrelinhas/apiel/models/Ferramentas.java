package com.entrelinhas.apiel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "ferramentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ferramentas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ferramentas", unique = true)
  private Long idFerramentas;

  @Column(name = "nome_ferramenta", length = 255)
  private String nomeFerramenta;

  @Column(name = "servico_minimo", length = 255)
  private String servicoMinimo;

  // extra! Pai
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_pedidos", referencedColumnName = "id_pedidos")
  private Pedidos pedidos;

  // extra! Pai
  @ManyToOne
  @JoinColumn(name = "id_precificacao", referencedColumnName = "id_precificacao")
  private Precificacao precificacao;

  // Filho
  @OneToOne(mappedBy = "ferramentas", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Perfil perfil;

  // Filho
  @OneToOne(mappedBy = "ferramentas", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Propriedades propriedades;
}

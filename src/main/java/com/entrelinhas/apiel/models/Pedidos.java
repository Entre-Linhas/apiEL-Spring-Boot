package com.entrelinhas.apiel.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Pedidos.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
  public static final String TABLE_NAME = "pedidos";

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos", unique = true)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "estado")
    private String estado;

    // Pai
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Mãe
    @OneToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    private Status status;

    // Filho
  @OneToOne(mappedBy = "pedidos", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private Precificacao precificacao;

  //Filho
  @OneToMany(mappedBy = "pedidos", cascade = CascadeType.PERSIST)
  @JsonIgnore 
  private List<Ferramentas> ferramentas;
}

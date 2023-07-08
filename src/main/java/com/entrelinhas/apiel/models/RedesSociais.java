package com.entrelinhas.apiel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = RedesSociais.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedesSociais {

  public static final String TABLE_NAME = "redes_sociais";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rede_social", unique = true)
  private Long idRedeSocial;

  @Column(name = "link")
  private String link;

  // Pai
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
  private Usuario usuario;
}

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
@Table(name = Notificacao.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {
  public static final String TABLE_NAME = "notificacao";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_notificacao", unique = true)
  private Long idNotificacao;

  @Column(name = "nome_notificacao", length = 255)
  private String nomeNotificacao;

  @Column(name = "descricao", columnDefinition = "TEXT")
  private String descricao;

  @Column(name = "source", length = 255)
  private String source;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
  private Usuario usuario;
}

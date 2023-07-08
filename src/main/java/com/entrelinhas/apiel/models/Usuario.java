package com.entrelinhas.apiel.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
/* import jakarta.persistence.ManyToOne; */
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Usuario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Usuario {

  public interface CriarUsuario {}

  public interface AtualizarUsuario {}

  public static final String TABLE_NAME = "usuario";

  // dados da tabela
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario", unique = true)
  private Long idUsuario;

  @Column(name = "nome", length = 255, nullable = false)
  @NotBlank(groups = CriarUsuario.class)
  @Size(min = 2, max = 255)
  private String nome;

  @Column(name = "sobrenome", length = 255, nullable = false)
  @NotBlank(groups = CriarUsuario.class)
  @Size(min = 2, max = 255)
  private String sobrenome;

  @Column(name = "email", length = 255, nullable = true, unique = true)
  @NotBlank(groups = CriarUsuario.class)
  //@Email(groups = CriarUsuario.class)
  @Size(groups = CriarUsuario.class, min = 2, max = 255)
  private String email;

  @Column(name = "senha", length = 20, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 8,
    max = 20
  )
  private String senha;

  @Column(name = "cep", length = 9, nullable = true)
  @NotNull(groups = CriarUsuario.class)
  @NotEmpty(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 20
  )
  private String cep;

  @Column(name = "data_inicio", length = 60, nullable = true)
  @NotNull(groups = CriarUsuario.class)
  @NotEmpty(groups = CriarUsuario.class)
  private LocalDate dataInicio;

  @Column(name = "data_termino", length = 60, nullable = true)
  @NotNull(groups = CriarUsuario.class)
  @NotEmpty(groups = CriarUsuario.class)
  private LocalDate dataTermino;

  @Column(name = "progresso", length = 60, nullable = true)
  @NotNull(groups = CriarUsuario.class)
  @NotEmpty(groups = CriarUsuario.class)
  private Float progresso;

  @Column(name = "endereco", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 255
  )
  private String endereco;

  @Column(name = "numero", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 13
  )
  private String numero;

  @Column(name = "bairro", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 255
  )
  private String bairro;

  @Column(name = "cidade", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 255
  )
  private String cidade;

  @Column(name = "cpf", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 20
  )
  private String cpf;

  @Column(name = "cnpj", length = 60, nullable = true)
  @NotBlank(groups = CriarUsuario.class)
  @Size(
    groups = { CriarUsuario.class, AtualizarUsuario.class },
    min = 2,
    max = 20
  )
  private String cnpj;

  // ele se conecta
  // Pai
  @OneToOne
  @JoinColumn(name = "id_plano", referencedColumnName = "id_plano")
  private Plano plano;

  // Pai
  @OneToOne
  @JoinColumn(name = "id_status", referencedColumnName = "id_status")
  private Status status;

  // OneToOne=conectados com ele e, JsonIngore=evitando repercusão infinita evitando trazer os dados do perfil e travando a resposta
  // Filho
  @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Perfil perfil;

  // Filho
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
  @JsonIgnore
  private List<Pedidos> pedidos;

  // Filho
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private List<RedesSociais> redesSociais;

  // Filho
  @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private List<Conquista> conquista;

  // Filho
  @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
  @JsonIgnore 
  private Notificacao notificacao;
}
// atalho util, shift + alt + o    ---   mvn clean install -U

package com.entrelinhas.apiel.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

  public UsuarioDto(Usuario user) {
    this.setIdUsuario(user.getIdUsuario());
    this.setNome(user.getNome());
    this.setSobrenome(user.getSobrenome());
    this.setEmail(user.getEmail());
    this.setCep(user.getCep());
    this.setDataInicio(user.getDataInicio());
    this.setDataTermino(user.getDataTermino());
    this.setProgresso(user.getProgresso());
    this.setEndereco(user.getEndereco());
    this.setNumero(user.getNumero());
    this.setBairro(user.getBairro());
    this.setCidade(user.getCidade());
    this.setCpf(user.getCpf());
    this.setCnpj(user.getCnpj());
    this.setPlano(user.getPlano());
    this.setStatus(user.getStatus());
    this.setPerfil(user.getPerfil());
    this.setPedidos(user.getPedidos());
    this.setRedesSociais(user.getRedesSociais());
    this.setConquista(user.getConquista());
    this.setNotificacao(user.getNotificacao());
  }

  private Long idUsuario;
  private String nome;
  private String sobrenome;
  private String email;
  private String cep;
  private LocalDate dataInicio;
  private LocalDate dataTermino;
  private Float progresso;
  private String endereco;
  private String numero;
  private String bairro;
  private String cidade;
  private String cpf;
  private String cnpj;
  private Plano plano;
  private Status status;
  private Perfil perfil;
  private List<Pedidos> pedidos;
  private List<RedesSociais> redesSociais;
  private List<Conquista> conquista;
  private Notificacao notificacao;
}

package com.entrelinhas.apiel.services;

import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.repositories.UsuarioRepository;

import jakarta.validation.ValidationException;

import java.util.List;
/* import java.util.Set; */
import java.util.Optional;
//import java.util.concurrent.TimeoutException;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/* import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation; */

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final PerfilService perfilService;

  public UsuarioService(UsuarioRepository usuarioRepository, PerfilService perfilService) {
    this.usuarioRepository = usuarioRepository;
    this.perfilService = perfilService;
  }

  public Usuario obterUsuarioPorId(Long id) {
    try {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else { // tratamento de erro de logica
            return usuario.orElseThrow(() -> new RuntimeException(
                "1Usuario não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getName()
            ));
            /* else { // tratamento de erro de logica
            return usuario.orElseThrow(() -> new ResourceNotFoundException(
                "Usuario não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getName()
            )); */
        }
    } catch (DataAccessException e) { // Tratamento de erro de acesso a dados
        throw new RuntimeException("2Erro de acesso a dados ao obter o usuário.", e);
    }  catch (ValidationException e) { // Tratamento de erro de validação
        throw new RuntimeException("3Erro de validação ao obter o usuário.", e);
    }
    //return usuarioRepository.findById(id).orElse(null);
  }
  // extra para outras operações avançadas de conexão de rede
  /* catch (TimeoutException e) { // Tratamento de erro de timeout - O crud não necessitara disso nesse service e se torna anormal ocorrer e por isso não possui essa impleentação(crud é do Spring Data JPA)
        throw new RuntimeException("Tempo limite excedido ao obter o usuário.", e);
    } */

  public List<Usuario> obterTodosUsuarios() {
    return usuarioRepository.findAll();
  }

  @Transactional
  public Usuario criarUsuario(Usuario usuario) {
    if (usuarioRepository.existsByEmail(usuario.getEmail())) {
        throw new RuntimeException("O email já está sendo usado por outro usuário.");
    } else {
    // Adicione a lógica para validar os dados do usuário, se necessário
    /* Set<ConstraintViolation<Usuario>> violations = Validation.buildDefaultValidatorFactory()
        .getValidator()
        .validate(usuario);
    
    if (!violations.isEmpty()) {
        // Se houver violações, você pode lançar uma exceção ou lidar com elas de acordo com suas necessidades
        throw new RuntimeException("Dados inválidos do usuário.");
    } */
    // Realize a lógica para criar um novo usuário no banco de dados
    
    Usuario newUsuario = usuarioRepository.save(usuario);
    perfilService.criarPerfilParaUsuario(newUsuario);
    return newUsuario;
  }
  }


  @Transactional
  public Usuario atualizarUsuario(Usuario usuarioExistente, Usuario usuarioRece, Long id) {
    // Atualizar as informações do usuário existente com os dados do usuário recebido
    if (usuarioRece.getIdUsuario() != null) {
      usuarioExistente.setIdUsuario(usuarioRece.getIdUsuario());
    }
    if (usuarioRece.getNome() != null) {
        usuarioExistente.setNome(usuarioRece.getNome());
    }
    if (usuarioRece.getSobrenome() != null) {
        usuarioExistente.setSobrenome(usuarioRece.getSobrenome());
    }
    if (usuarioRece.getEmail() != null) {
        usuarioExistente.setEmail(usuarioRece.getEmail());
    }
    if (usuarioRece.getSenha() != null) {
        usuarioExistente.setSenha(usuarioRece.getSenha());
    }
    if (usuarioRece.getCep() != null) {
        usuarioExistente.setCep(usuarioRece.getCep());
    }
    if (usuarioRece.getDataInicio() != null) {
        usuarioExistente.setDataInicio(usuarioRece.getDataInicio());
    }
    if (usuarioRece.getDataTermino() != null) {
        usuarioExistente.setDataTermino(usuarioRece.getDataTermino());
    }
    if (usuarioRece.getProgresso() != null) {
        usuarioExistente.setProgresso(usuarioRece.getProgresso());
    }
    if (usuarioRece.getEndereco() != null) {
        usuarioExistente.setEndereco(usuarioRece.getEndereco());
    }
    if (usuarioRece.getNumero() != null) {
        usuarioExistente.setNumero(usuarioRece.getNumero());
    }
    if (usuarioRece.getBairro() != null) {
        usuarioExistente.setBairro(usuarioRece.getBairro());
    }
    if (usuarioRece.getCidade() != null) {
        usuarioExistente.setCidade(usuarioRece.getCidade());
    }
    if (usuarioRece.getCpf() != null) {
        usuarioExistente.setCpf(usuarioRece.getCpf());
    }
    if (usuarioRece.getCnpj() != null) {
        usuarioExistente.setCnpj(usuarioRece.getCnpj());
    }
    // Adicione outras verificações para outros campos conforme necessário

    return usuarioRepository.save(usuarioExistente);
  }

  public void excluirUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }
}

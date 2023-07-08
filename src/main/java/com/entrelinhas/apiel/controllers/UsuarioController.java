package com.entrelinhas.apiel.controllers;

// import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entrelinhas.apiel.models.PayloadLogin;
import com.entrelinhas.apiel.models.PerfilDto;
import com.entrelinhas.apiel.models.Usuario;
import com.entrelinhas.apiel.models.Usuario.CriarUsuario;
import com.entrelinhas.apiel.models.UsuarioDto;
import com.entrelinhas.apiel.services.PerfilService;
import com.entrelinhas.apiel.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
  
  private final UsuarioService usuarioService;

  private final PerfilService perfilService;
  

  public UsuarioController(UsuarioService usuarioService, PerfilService perfilService) {
    this.usuarioService = usuarioService;
    this.perfilService = perfilService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Long id) {
    Usuario usuario = usuarioService.obterUsuarioPorId(id);
    if (usuario != null) {
      return ResponseEntity.ok().body(usuario);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Usuario>> obterTodosUsuarios() {
  List<Usuario> usuariosRet = usuarioService.obterTodosUsuarios();
  if (!usuariosRet.isEmpty()) {
      return ResponseEntity.ok(usuariosRet);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  @PostMapping("/cadastro")
  @Validated(CriarUsuario.class)
  public ResponseEntity<UsuarioDto> criarUsuario(@Valid @RequestBody Usuario usuario) {
    Usuario novoUsuario = usuarioService.criarUsuario(usuario);
    /* URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoUsuario.getIdUsuario().toUri());
    return ResponseEntity.created(uri).build().body(novoUsuario); */
    return ResponseEntity.ok(new UsuarioDto(novoUsuario));
  }

  @PostMapping("/login")
  @Validated
  public ResponseEntity<PerfilDto> verificacaoUsuario(@Valid @RequestBody PayloadLogin payloadLogin) {
    
    PerfilDto perfil = perfilService.perfilLogin(payloadLogin);

    return ResponseEntity.ok(perfil);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioRece) {
    Usuario usuarioExistente = usuarioService.obterUsuarioPorId(id);
    if (usuarioExistente != null && usuarioRece != null) {
        

        // Realizar a atualização no banco de dados
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(usuarioExistente, usuarioRece, id);
        return ResponseEntity.ok(usuarioAtualizado);
    } else {
        return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
    usuarioService.excluirUsuario(id);
    return ResponseEntity.noContent().build();
  }
}

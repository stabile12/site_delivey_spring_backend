package com.burguer.user.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.burguer.user.infra.security.TokenService;
import com.burguer.user.models.Usuario;
import com.burguer.user.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  UsuarioRepository repository;

  @Autowired
  TokenService tokenService;

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Usuario>> listarInfoUsuario(@PathVariable Long id) {
    var usuario = repository.findById(id);

    return ResponseEntity.ok(usuario);
  }

  
}

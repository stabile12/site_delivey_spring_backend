package com.burguer.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.user.DTO.AtualizaUsuarioDTO;
import com.burguer.user.DTO.UsuarioInfoDTO;
import com.burguer.user.infra.security.TokenService;
import com.burguer.user.service.UsuarioService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  UsuarioService service;

  @Autowired
  TokenService tokenService;

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioInfoDTO> listarInfoUsuario(@PathVariable Long id) {
    var usuario = service.listarInfoUsuario(id);

    return ResponseEntity.ok(usuario);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<AtualizaUsuarioDTO> atualizarUsuario(@RequestBody AtualizaUsuarioDTO dto) {
    var infoAtualizada = service.atualizarUsuario(dto);

    return ResponseEntity.ok(infoAtualizada);
  }
  
}

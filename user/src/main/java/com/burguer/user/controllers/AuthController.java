package com.burguer.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.user.DTO.LoginDTO;
import com.burguer.user.DTO.RegistroDTO;
import com.burguer.user.infra.security.TokenService;
import com.burguer.user.models.Usuario;
import com.burguer.user.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  UsuarioRepository repository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginDTO data) {
    
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());

    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((Usuario) auth.getPrincipal());
    return ResponseEntity.ok(token);
  }

  @PostMapping("/register")
  public ResponseEntity<Usuario> register(@RequestBody RegistroDTO dto) {
    if (repository.findByEmail(dto.email()) != null) {
      return ResponseEntity.badRequest().build();
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());

    Usuario novoUsuario = new Usuario();
    novoUsuario.setNome(dto.nome());
    novoUsuario.setEmail(dto.email());
    novoUsuario.setSenha(encryptedPassword);
    novoUsuario.setTelefone(dto.telefone());
    novoUsuario.setCpf(dto.cpf());
    novoUsuario.setRole(dto.role());

    repository.save(novoUsuario);
    return ResponseEntity.ok(novoUsuario);
  }

  @PostMapping("/validar-token")
  public ResponseEntity<Boolean> validarToken(@RequestBody String token) {
    String subject = tokenService.validateToken(token);

    if (!subject.isEmpty()) {
      return ResponseEntity.ok().body(true);
    } else {
      
      return ResponseEntity.badRequest().body(false);
    }
  }

  @PostMapping("/checar-role")
  public ResponseEntity<Boolean> checarPermissao(@RequestBody String token) {
    String role = tokenService.checkRole(token);
    System.out.println(role);

    if(role.equals("admin")) {
      return ResponseEntity.ok().body(true);
    } else {
      return ResponseEntity.status(401).body(false);
    }
  } 

}

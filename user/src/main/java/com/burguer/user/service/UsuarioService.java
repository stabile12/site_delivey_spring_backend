package com.burguer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.user.DTO.AtualizaUsuarioDTO;
import com.burguer.user.DTO.UsuarioInfoDTO;
import com.burguer.user.models.Usuario;
import com.burguer.user.repository.UsuarioRepository;

@Service
public class UsuarioService {
  
  @Autowired
  private UsuarioRepository repository;

  public UsuarioInfoDTO listarInfoUsuario(Long id) {
    var usuario = repository.getReferenceById(id);
    UsuarioInfoDTO usuarioInfo = new UsuarioInfoDTO(
      usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getCpf()
      );

    return usuarioInfo;
  }


  public AtualizaUsuarioDTO atualizarUsuario(AtualizaUsuarioDTO dto) {
    Usuario usuario = repository.getReferenceById(dto.id());
    usuario.setNome(dto.nome());
    usuario.setEmail(dto.email());
    usuario.setCpf(dto.cpf());
    usuario.setTelefone(dto.telefone());

    return dto;
  }
}

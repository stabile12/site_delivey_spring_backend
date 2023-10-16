package com.burguer.user.DTO;

import com.burguer.user.models.UserRole;

public record RegistroDTO(
  String nome,
  String email,
  String senha,
  String telefone,
  String cpf,
  UserRole role
) {
  
}

package com.burguer.user.DTO;

import jakarta.validation.constraints.NotBlank;

public record AtualizaUsuarioDTO(
  @NotBlank
  Long id,
  @NotBlank
  String nome,
  @NotBlank
  String email,
  @NotBlank
  String telefone,
  @NotBlank
  String cpf
) {
  
}

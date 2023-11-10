package com.burguer.user.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalvarCartaoDTO(
  @NotNull
  Long id_cliente,
  @NotBlank
  String numero,
  @NotBlank
  String validade,
  @NotBlank
  String cvv,
  @NotBlank
  String nome_cliente
) {
  
}

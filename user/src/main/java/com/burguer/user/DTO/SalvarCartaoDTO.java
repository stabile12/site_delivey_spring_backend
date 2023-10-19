package com.burguer.user.DTO;

import jakarta.validation.constraints.NotBlank;

public record SalvarCartaoDTO(
  @NotBlank
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

package com.burguer.pagamentos.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PagamentoDTO(
  @NotNull
  Long id_cliente,
  @NotNull
  Long id_pedido,
  @NotBlank
  String cpf_cliente,
  @NotNull
  double valor
) {
  
}

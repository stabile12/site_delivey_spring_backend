package com.burguer.user.DTO;

public record ListarCartaoDTO(
  Long id,
  Long id_cliente,
  String numero,
  String validade,
  String cvv,
  String nome_cliente
) {
  
}

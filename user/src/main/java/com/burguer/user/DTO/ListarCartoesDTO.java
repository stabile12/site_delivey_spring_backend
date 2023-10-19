package com.burguer.user.DTO;

public record ListarCartoesDTO(
  String numero,
  String validade,
  String cvv,
  String nome_cliente
) {
  
}

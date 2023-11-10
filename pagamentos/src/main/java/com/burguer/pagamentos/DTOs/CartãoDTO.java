package com.burguer.pagamentos.DTOs;

public record CartãoDTO(
  Long id,
  Long id_cliente,
  String numero,
  String validade,
  String cvv,
  String nome_cliente
) {
  
}

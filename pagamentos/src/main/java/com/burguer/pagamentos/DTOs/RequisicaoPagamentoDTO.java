package com.burguer.pagamentos.DTOs;


public record RequisicaoPagamentoDTO(
  String nome,
  String numero,
  String validade,
  String cvv,
  String cpf,
  double valor
) {
  
}

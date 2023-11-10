package com.burguer.pagamentos.DTOs;

public record DadosWrapperDTO(
  PagamentoDTO pagamentoDTO,
  RequisicaoPagamentoDTO cartaoDTO
) {
  
}

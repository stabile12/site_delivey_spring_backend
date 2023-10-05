package com.burguer.avaliacoes.dto;

public record AvaliacaoDto(
        Long id_cliente,
        Long id_produto,
        int nota,
        Long id_pedido
) {
  
}

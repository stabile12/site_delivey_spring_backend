package com.burguer.pedidos.DTOs;

public record ItemPedidoDTO(
  Long id_produto,
  String nome_produto,
  Double preco
) {
  
}

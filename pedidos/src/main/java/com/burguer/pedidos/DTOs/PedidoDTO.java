package com.burguer.pedidos.DTOs;

public record PedidoDTO(
  Long id_pedido,
  Double total,
  String status,
  Long id_cliente
) {
  
}

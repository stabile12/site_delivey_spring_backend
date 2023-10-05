package com.burguer.pedidos.DTOs;

import java.util.List;

public record CriarPedidoDTO(
  Long id_cliente,
  List<ItemPedidoDTO> produtos
) {
  
}

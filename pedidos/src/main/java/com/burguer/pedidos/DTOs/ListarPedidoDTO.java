package com.burguer.pedidos.DTOs;

import java.util.List;

import com.burguer.pedidos.models.ItemPedido;
import com.burguer.pedidos.models.Status;


public record ListarPedidoDTO(
  Long id_pedido,
  Double total,
  Status status,
  Long id_cliente,
  List<ItemPedido> produtos
) {

}

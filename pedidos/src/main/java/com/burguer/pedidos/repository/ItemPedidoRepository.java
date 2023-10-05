package com.burguer.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.burguer.pedidos.models.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    @Query("SELECT i FROM ItemPedido i WHERE i.id_pedido = :idPedido")
    List<ItemPedido> findItemsByPedidoId(@Param("idPedido") Long idPedido);
}

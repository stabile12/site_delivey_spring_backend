package com.burguer.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.burguer.pedidos.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  @Query("SELECT i FROM Pedido i WHERE i.id_cliente = :idCliente")
  List<Pedido> findByClienteId(@Param("idCliente") Long idCliente);

}

package com.burguer.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burguer.pedidos.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
  
}

package com.burguer.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.burguer.pedidos.service.PedidoService;

@Configuration
public class StatusPedidoListener {

  @Autowired
  PedidoService service;

  @RabbitListener(queues = "status-pedido")
  public void alterarStatusPedido(Long id){
    String response = service.atualizaStatusPedidoConfirmado(id);
    System.out.println(response);
  }
}

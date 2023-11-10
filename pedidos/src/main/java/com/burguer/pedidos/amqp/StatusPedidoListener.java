package com.burguer.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatusPedidoListener {
  
  @RabbitListener(queues = "status-pedido")
  public void alterarStatusPedido(Long id){
    System.out.println("mensagem recebida " + id);
  }
}

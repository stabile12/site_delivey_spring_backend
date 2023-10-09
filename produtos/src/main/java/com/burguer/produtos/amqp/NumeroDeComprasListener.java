package com.burguer.produtos.amqp;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import com.burguer.produtos.service.ProdutoService;

import jakarta.transaction.Transactional;

@Configuration
@Transactional
public class NumeroDeComprasListener {
  @Autowired
    ProdutoService service;

    @RabbitListener(queues = "compras-produtos")
    public void receberAvaliacao(List<Long> ids) {
      service.atualizaNumeroDeCompras(ids);
    }
}

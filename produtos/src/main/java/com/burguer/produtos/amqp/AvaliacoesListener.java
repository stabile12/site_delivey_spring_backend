package com.burguer.produtos.amqp;

import com.burguer.produtos.DTO.AvaliacaoDto;
import com.burguer.produtos.repository.ProdutosRepository;
import com.burguer.produtos.service.ProdutoService;

import jakarta.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Transactional
public class AvaliacoesListener {

    @Autowired
    ProdutosRepository repository;

    @Autowired
    ProdutoService service;

    @RabbitListener(queues = "avaliacoes-produtos")
    public void receberAvaliacao(AvaliacaoDto dto) {
        var nota = service.atualizaNota(dto.id_produto(), dto.nota());
        System.out.println(nota);
    }
}

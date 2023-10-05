package com.burguer.avaliacoes.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.avaliacoes.dto.AvaliacaoDto;
import com.burguer.avaliacoes.models.Avaliacao;
import com.burguer.avaliacoes.repository.AvaliacoesRepository;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  AvaliacoesRepository repository;

  @PostMapping
  @Transactional
  public void enviaAvaliacao(@RequestBody AvaliacaoDto dto) {
    Avaliacao avaliacao = new Avaliacao(dto);
    repository.save(avaliacao);

    rabbitTemplate.convertAndSend("avaliacoes.ex", "", dto );
    
  }
}

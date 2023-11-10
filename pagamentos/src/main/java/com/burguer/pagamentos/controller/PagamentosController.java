package com.burguer.pagamentos.controller;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.pagamentos.DTOs.DadosWrapperDTO;
import com.burguer.pagamentos.DTOs.RequisicaoPagamentoDTO;
import com.burguer.pagamentos.service.BancoService;
import com.burguer.pagamentos.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {
  
  @Autowired
  BancoService bancoService;

  @Autowired
  PagamentoService pagamentoService;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostMapping
  public ResponseEntity<Object> receberPagamento(@RequestBody DadosWrapperDTO dto) throws IOException, InterruptedException {
    RequisicaoPagamentoDTO requisicaoPagamentoDTO = dto.cartaoDTO();
    var requisicao = bancoService.recebeDadosCartao(requisicaoPagamentoDTO);

    if (requisicao) {
      pagamentoService.salvarPagamento(dto.pagamentoDTO());

      rabbitTemplate.convertAndSend("status.ex", "", dto.pagamentoDTO().id_pedido());
      return ResponseEntity.ok(dto.pagamentoDTO());
    }else {
      return ResponseEntity.badRequest().body("Falha ao processar pagamento!");
    }
  }
}

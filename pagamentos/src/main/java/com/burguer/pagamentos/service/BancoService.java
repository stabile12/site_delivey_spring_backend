package com.burguer.pagamentos.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.pagamentos.DTOs.RequisicaoPagamentoDTO;
import com.burguer.pagamentos.http.RequisicaoBancaria;

@Service
public class BancoService {

  @Autowired
  private RequisicaoBancaria requisicaoBancaria;
  
  public Boolean recebeDadosCartao(RequisicaoPagamentoDTO dto) throws IOException, InterruptedException {
    String uri = "http://localhost:8083/check";

    System.out.println("dto que é enviado para a requisicao " + dto);

    var response = requisicaoBancaria.dispararRequisicaoPost(uri, dto);

    System.out.println(dto);
    System.out.println(response);

    if (response.statusCode() == 200) {
      System.out.println("Requisição bem-sucedida");
      return true;

    } else {
      System.out.println("Falha na requisição");
      return false;
    }
  }
}

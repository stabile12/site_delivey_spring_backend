package com.burguer.pagamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.pagamentos.DTOs.PagamentoDTO;
import com.burguer.pagamentos.models.Pagamento;
import com.burguer.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoService {
  
  @Autowired
  PagamentoRepository repository;

  public PagamentoDTO salvarPagamento(PagamentoDTO dto) {
    Pagamento pagamento = new Pagamento(dto);
    var novoPagamento = repository.save(pagamento);
    
    return dto;
  }
}

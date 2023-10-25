package com.burguer.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.user.DTO.SalvarCartaoDTO;
import com.burguer.user.models.Cartao;
import com.burguer.user.repository.CartaoRepository;

@Service
public class CartaoService {
  
  @Autowired
  private CartaoRepository cartaoRepository;

  public SalvarCartaoDTO salvarCartao(SalvarCartaoDTO dto) {
    Cartao cartao = new Cartao(dto);
    

    cartaoRepository.save(cartao);

    return dto;
  }

  /*public List<ListarCartoesDTO> listarCartoes(Long id) {
    List<Cartao> cartoes = cartaoRepository.findAllByClienteId(id);
  }*/
}

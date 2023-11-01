package com.burguer.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.user.DTO.ListarCartaoDTO;
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

  public List<ListarCartaoDTO> listarCartoes(Long id) {
    List<Cartao> cartoes = cartaoRepository.findAllByClienteId(id);
    List<ListarCartaoDTO> listaCartoes = new ArrayList<>();
    for (Cartao cartao : cartoes) {
      ListarCartaoDTO cartaoDTO = new ListarCartaoDTO(
          cartao.getId(),
          cartao.getId_cliente(),
          cartao.getNumero(),
          cartao.getValidade(),
          cartao.getCvv(),
          cartao.getNome_cliente());
      listaCartoes.add(cartaoDTO);
    }

    return listaCartoes;
  }
}

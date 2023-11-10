package com.burguer.pagamentos.models;

import java.time.LocalDateTime;

import com.burguer.pagamentos.DTOs.PagamentoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagamentos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pagamento;

  private Long id_cliente;

  private Long id_pedido;

  private String cpf_cliente;

  private double valor;

  private LocalDateTime feito_em;

  public Pagamento(PagamentoDTO dto) {
    this.id_cliente = dto.id_cliente();
    this.id_pedido = dto.id_pedido();
    this.cpf_cliente = dto.cpf_cliente();
    this.valor = dto.valor();
    this.feito_em = LocalDateTime.now();
  }
}

package com.burguer.user.models;

import com.burguer.user.DTO.SalvarCartaoDTO;

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
@Table(name = "cartoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long id_cliente;

  private String numero;

  private String validade;

  private String cvv;

  private String nome_cliente;

  public Cartao(SalvarCartaoDTO dto) {
    this.id_cliente = dto.id_cliente();
    this.numero = dto.numero();
    this.validade = dto.validade();
    this.cvv = dto.cvv();
    this.nome_cliente = dto.nome_cliente();
  }
}

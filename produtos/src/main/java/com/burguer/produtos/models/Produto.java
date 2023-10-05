package com.burguer.produtos.models;

import com.burguer.produtos.DTO.ProdutoDto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private double preco;

  @Column(name = "avaliacao")
  private double pontos;

  private String descricao;

  private Categoria categoria;

  private boolean ativo;

  private int numero_de_compras;

  private int numero_de_avaliacoes;

  public Produto(ProdutoDto dto) {
    this.nome = dto.nome();
    this.preco = dto.preco();
    this.descricao = dto.descricao();
    this.pontos = 0;
    this.categoria = dto.categoria();
    this.ativo = dto.ativo();
    this.numero_de_compras = 0;
    this.numero_de_avaliacoes = 0;
  }

  public void excluir() {
    this.ativo = false;
} 

}

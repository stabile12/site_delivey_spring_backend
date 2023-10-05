package com.burguer.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.produtos.DTO.AtualizarProdutoDTO;
import com.burguer.produtos.DTO.ProdutoDto;
import com.burguer.produtos.models.Produto;
import com.burguer.produtos.repository.ProdutosRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutosRepository repository;

  @Transactional
  public ProdutoDto criaProduto(ProdutoDto dto) {
    Produto produto = new Produto(dto);
    repository.save(produto);

    return dto;
  }

  public List<Produto> listar() {
    List<Produto> lista = repository.findByAtivoTrue();
    return lista;
  }

  @Transactional
  public void deletarProduto(Long id) {
    try {
      Produto produto = repository.getReferenceById(id);
      produto.excluir();

    } catch (Exception e) {
      System.out.println("deu merda");
    }
  }

  @Transactional
  public AtualizarProdutoDTO atualizarProduto(AtualizarProdutoDTO dto) {
    
      Produto produto = repository.getReferenceById(dto.id());
      produto.setNome(dto.nome());
      produto.setPreco(dto.preco());
      produto.setDescricao(dto.descricao());
      produto.setCategoria(dto.categoria());
      return dto;
  }

  @Transactional
  public double atualizaNota(Long id, int nota) {
    Produto produto = repository.getReferenceById(id);

    var numero_de_avaliacoes = produto.getNumero_de_avaliacoes();
    var pontos = produto.getPontos();

    produto.setNumero_de_avaliacoes(numero_de_avaliacoes + 1);
    produto.setPontos(pontos + nota );

    double avaliacao = produto.getPontos()/produto.getNumero_de_avaliacoes();

    return avaliacao;
  }

}

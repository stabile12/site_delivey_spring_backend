package com.burguer.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.produtos.DTO.AtualizarProdutoDTO;
import com.burguer.produtos.DTO.ProdutoDto;
import com.burguer.produtos.models.Produto;
import com.burguer.produtos.service.ProdutoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService service;
  
  @PostMapping
  public ResponseEntity<ProdutoDto> criar(@RequestBody  ProdutoDto dto) {
    ProdutoDto produto = service.criaProduto(dto);

    return ResponseEntity.ok(produto);
  }

  @GetMapping
  public ResponseEntity<List<Produto>> listar() {
    List<Produto> produtos = service.listar();

    return ResponseEntity.ok(produtos);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Long> deletarProduto(@PathVariable Long id) {
    service.deletarProduto(id);

    return ResponseEntity.noContent().build();
  }

  @PutMapping
  @Transactional
  public ResponseEntity<AtualizarProdutoDTO> atualizarProduto(@RequestBody AtualizarProdutoDTO dto) {
    service.atualizarProduto(dto);
    return ResponseEntity.ok(dto);
  }


}

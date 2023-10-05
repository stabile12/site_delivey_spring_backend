package com.burguer.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burguer.produtos.models.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

  List<Produto> findByAtivoTrue();
  
}

package com.burguer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burguer.user.models.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{
  
}

package com.burguer.avaliacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burguer.avaliacoes.models.Avaliacao;

public interface AvaliacoesRepository extends JpaRepository<Avaliacao, Long>{
  
}

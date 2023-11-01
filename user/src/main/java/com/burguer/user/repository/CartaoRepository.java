package com.burguer.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.burguer.user.models.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

  @Query("SELECT c FROM Cartao c WHERE c.id_cliente = :id")
  List<Cartao> findAllByClienteId(@Param("id") Long id);

}

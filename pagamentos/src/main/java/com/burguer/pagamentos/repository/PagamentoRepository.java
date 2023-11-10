package com.burguer.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burguer.pagamentos.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
  
}

package com.burguer.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.user.DTO.ListarCartaoDTO;
import com.burguer.user.DTO.SalvarCartaoDTO;
import com.burguer.user.service.CartaoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/card")
public class CartaoController {

  @Autowired
  CartaoService service;
           
  @PostMapping
  @Transactional
  public ResponseEntity<SalvarCartaoDTO> salvarCartao(@RequestBody @Valid SalvarCartaoDTO dto) {
    try {     
      service.salvarCartao(dto);
      
      return ResponseEntity.ok(dto);

    } catch (Exception e) {
      return ResponseEntity.status(400).build();
    }

  }

  @GetMapping("/{id}")
  public ResponseEntity<List<ListarCartaoDTO>> listarCartoes(@PathVariable Long id) {
    var listaCartoes = service.listarCartoes(id);

    return ResponseEntity.ok().body(listaCartoes);
  }
}

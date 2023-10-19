package com.burguer.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.user.DTO.SalvarCartaoDTO;
import com.burguer.user.service.CartaoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/card")
public class CartaoController {

  @Autowired
  CartaoService service;

  @PostMapping
  @Transactional
  public ResponseEntity<SalvarCartaoDTO> salvarCartao(@RequestBody SalvarCartaoDTO dto) {
    service.salvarCartao(dto);
    
    return ResponseEntity.ok(dto);

  }
}

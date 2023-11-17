package com.burguer.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burguer.pedidos.DTOs.CriarPedidoDTO;
import com.burguer.pedidos.DTOs.ListarPedidoDTO;
import com.burguer.pedidos.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private PedidoService service;
  
  @PostMapping
  public ResponseEntity<CriarPedidoDTO> criaPedido(@RequestBody CriarPedidoDTO dto) {
    service.criaPedido(dto);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ListarPedidoDTO> listarPedidoPorID(@PathVariable Long id) {
    var pedido = service.listarPedidoPorId(id);
    return ResponseEntity.ok(pedido);
  }

  @GetMapping("/cliente/{id}")
  public ResponseEntity<List<ListarPedidoDTO>> listarPedidosPorCliente(@PathVariable Long id) {
      var pedidos = service.listarPedidosPorCliente(id);
      return ResponseEntity.ok(pedidos);
  }
  
  // endpoint deve ser acessado somente por admins
  @GetMapping("/{id}/enviado")
  public ResponseEntity<String> atualizaStatusEnviado(@PathVariable Long id) {
    String resposta = service.atualizaStatusPedidoEnviado(id);
    return ResponseEntity.ok().body(resposta);
  }

  // endpoint deve ser acessado somente por admins
  @GetMapping("/{id}/entregue")
  public ResponseEntity<String> atualizaStatusEntregue(@PathVariable Long id) {
    String resposta = service.atualizaStatusPedidoEntregue(id);
    return ResponseEntity.ok().body(resposta);
  }

  
}

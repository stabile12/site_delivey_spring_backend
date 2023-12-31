package com.burguer.pedidos.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burguer.pedidos.DTOs.ItemPedidoDTO;
import com.burguer.pedidos.DTOs.ListarPedidoDTO;
import com.burguer.pedidos.DTOs.CriarPedidoDTO;
import com.burguer.pedidos.models.ItemPedido;
import com.burguer.pedidos.models.Pedido;
import com.burguer.pedidos.models.Status;
import com.burguer.pedidos.repository.ItemPedidoRepository;
import com.burguer.pedidos.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ItemPedidoRepository itemPedidoRepository;

  @Transactional
  public List<ItemPedidoDTO> criaPedido(CriarPedidoDTO dto) {
    Long id_cliente = dto.id_cliente();
    List<ItemPedidoDTO> produtos = dto.produtos();
    double total = 0;
    List<Long> ids_produtos = new ArrayList<>();
    

    for (ItemPedidoDTO produto : produtos) {
      ids_produtos.add(produto.id_produto());
    }

    rabbitTemplate.convertAndSend("compras.ex", "", ids_produtos);

    for (ItemPedidoDTO produto : produtos) {
      total += produto.preco();
    }

    Pedido pedido = new Pedido();
    pedido.setId_cliente(id_cliente);
    pedido.setTotal(total);
    pedido.setStatus(Status.AGUARDANDO);
    pedido.setFeito_em(LocalDateTime.now());

    pedidoRepository.save(pedido);

    for (ItemPedidoDTO produto : produtos) {
      ItemPedido itemPedido = new ItemPedido();

      itemPedido.setId_pedido(pedido.getId());
      itemPedido.setId_produto(produto.id_produto());
      itemPedido.setNome_produto(produto.nome_produto());
      itemPedido.setPreco(produto.preco());

      itemPedidoRepository.save(itemPedido);
    }
    return produtos;
  }

  public ListarPedidoDTO listarPedidoPorId(long id) {
    Pedido pedido = pedidoRepository.findById(id).get();
    List<ItemPedido> produtos = itemPedidoRepository.findItemsByPedidoId(id);
    ListarPedidoDTO dto = new ListarPedidoDTO(pedido.getId(), pedido.getTotal(), pedido.getStatus(),
        pedido.getId_cliente(), produtos);

    return dto;
  }

  public List<ListarPedidoDTO> listarPedidosPorCliente(long id) {
    List<Pedido> pedidos = pedidoRepository.findByClienteId(id);
    List<ListarPedidoDTO> lista = new ArrayList<>();

    for (Pedido pedido : pedidos) {
      List<ItemPedido> itensPedidos = itemPedidoRepository.findItemsByPedidoId(pedido.getId());

      List<ItemPedidoDTO> listaItensDTO = new ArrayList<>();
      for (ItemPedido itemPedido : itensPedidos) {
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO(itemPedido.getId(), itemPedido.getNome_produto(), itemPedido.getPreco());

        listaItensDTO.add(itemPedidoDTO);
        
      }
      
      ListarPedidoDTO pedidoDTO = new ListarPedidoDTO(pedido.getId(), pedido.getTotal(), pedido.getStatus(), pedido.getId_cliente(), itensPedidos);
      lista.add(pedidoDTO);
    }
    
    return lista;
  }

  public String atualizaStatusPedidoConfirmado(Long id) {
    try {
      var pedido = pedidoRepository.findById(id).get();

      pedido.setStatus(Status.CONFIRMADO);

      pedidoRepository.save(pedido);

      return "Status Atualizado para CONFIRMADO";
    } catch (Exception e) {
      return "Falha ao atualizar! - " + e.getMessage();
    }
  }

  public String atualizaStatusPedidoEnviado(Long id) {
    try {
      var pedido = pedidoRepository.findById(id).get();

      pedido.setStatus(Status.ENVIADO);

      pedidoRepository.save(pedido);

      return "Status Atualizado para ENVIADO";
    } catch (Exception e) {
      return "Falha ao atualizar! - " + e.getMessage();
    }
  }

  public String atualizaStatusPedidoEntregue(Long id) {
    try {
      var pedido = pedidoRepository.findById(id).get();

      pedido.setStatus(Status.ENTREGUE);

      pedidoRepository.save(pedido);

      return "Status Atualizado para ENTREGUE";
    } catch (Exception e) {
      return "Falha ao atualizar! - " + e.getMessage();
    }
  }
}

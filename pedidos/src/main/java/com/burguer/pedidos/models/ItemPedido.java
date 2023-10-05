package com.burguer.pedidos.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Long id_produto;

  Long id_pedido;

  String nome_produto;

  Double preco;
}

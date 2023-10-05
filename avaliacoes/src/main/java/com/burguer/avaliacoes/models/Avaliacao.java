package com.burguer.avaliacoes.models;

import com.burguer.avaliacoes.dto.AvaliacaoDto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long id_cliente;
    Long id_produto;
    Long id_pedido;
    int nota;

    public Avaliacao(AvaliacaoDto dto) {
        this.id_cliente = dto.id_cliente();
        this.id_produto = dto.id_produto();
        this.nota = dto.nota();
        this.id_pedido = dto.id_pedido();
    }

}

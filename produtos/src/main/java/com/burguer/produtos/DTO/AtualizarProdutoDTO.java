package com.burguer.produtos.DTO;

import com.burguer.produtos.models.Categoria;

public record AtualizarProdutoDTO(
    Long id,
    String nome,
    Double preco,
    String descricao,
    Categoria categoria
    ) {
}

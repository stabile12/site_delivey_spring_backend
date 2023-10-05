package com.burguer.produtos.DTO;

import com.burguer.produtos.models.Avaliacao;
import com.burguer.produtos.models.Categoria;

public record ProdutoDto(
    String nome,
    Double preco,
    String descricao,
    Avaliacao avaliacao,
    Categoria categoria,
    boolean ativo
) {

}

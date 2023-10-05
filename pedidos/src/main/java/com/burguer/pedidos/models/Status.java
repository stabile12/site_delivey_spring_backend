package com.burguer.pedidos.models;

public enum Status {
    AGUARDANDO("Aguardando confirmação"),
    CONFIRMADO("Pedido confirmado, aguardando envio"),
    ENVIADO("Pedido enviado, a caminho"),
    ENTREGUE("Pedido entregue com sucesso");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
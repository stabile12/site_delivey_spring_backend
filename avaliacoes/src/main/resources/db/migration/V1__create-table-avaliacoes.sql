CREATE TABLE avaliacoes (
    id SERIAL PRIMARY KEY,
    id_cliente BIGINT,
    id_produto BIGINT,
    nota VARCHAR(255),
    id_pedido BIGINT
);

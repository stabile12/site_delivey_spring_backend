CREATE TABLE item_pedido (
    id SERIAL PRIMARY KEY,
    id_produto INT NOT NULL,
    id_pedido INT,
    nome_produto VARCHAR(255) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);
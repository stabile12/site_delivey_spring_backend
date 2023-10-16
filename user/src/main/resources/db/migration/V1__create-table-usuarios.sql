CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(20),
    cpf VARCHAR(14),
    role VARCHAR(255)
);

CREATE TABLE cartoes (
    id SERIAL PRIMARY KEY,
    id_cliente BIGINT,
    numero VARCHAR(16),
    validade VARCHAR(7),
    cvv VARCHAR(3),
    nome_cliente VARCHAR(255)
);
create table pagamentos(
  id_pagamentos SERIAL PRIMARY KEY,
  id_cliente integer,
  cpf_cliente char(11),
  id_pedido integer,
  valor numeric(10,2)
)
CREATE TABLE entrega(
	id BIGINT NOT null AUTO_INCREMENT,
    cliente_id BIGINT NOT null,
    taxa DECIMAL(10,2) NOT null,
    status VARCHAR(20) NOT null,
    data_pedido DATETIME NOT null,
    data_finalizacao DATETIME,

    destinatario_nome VARCHAR(60) NOT null,
    destinatario_logradouro VARCHAR(255) NOT null,
    destinatario_numero VARCHAR(5) NOT null,
    destinatario_complemento VARCHAR(60) NOT null,
    destinatario_bairro VARCHAR(30) NOT null,

    PRIMARY KEY (id)
);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id);
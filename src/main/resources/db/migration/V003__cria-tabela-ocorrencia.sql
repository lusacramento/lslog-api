CREATE TABLE ocorrencia (
	id bigint NOT null AUTO_INCREMENT,
    entrega_id bigint NOT null,
    descricao text NOT null,
    data_registro datetime NOT null,

    PRIMARY KEY (id)
);

ALTER TABLE ocorrencia ADD CONSTRAINT fk_ocorrencia_entrega FOREIGN KEY (entrega_id) REFERENCES entrega (id)
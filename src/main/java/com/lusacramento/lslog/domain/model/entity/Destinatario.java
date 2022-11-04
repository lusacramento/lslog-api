package com.lusacramento.lslog.domain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable // classe a ser embutida dentro de uma tabela do banco de dados.
public class Destinatario {

    // Não tem id porque esta entidade vai estar embutida dentro de uma tabela do bd.
    @Column(name = "destinatario_nome")
    private String nome;

    @Column(name = "destinatario_logradouro")
    private String logradouro;

    @Column(name = "destinatario_numero")
    private String numero;

    @Column(name="destinatario_complemento")
    private String complemento;

    @Column(name = "destinatario_bairro")
    private String bairro;
}

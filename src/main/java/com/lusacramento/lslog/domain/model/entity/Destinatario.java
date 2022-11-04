package com.lusacramento.lslog.domain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable // classe a ser embutida dentro de uma tabela do banco de dados.
public class Destinatario {

    // Não tem id porque esta entidade vai estar embutida dentro de uma tabela do bd.
    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;

    @NotBlank
    @Column(name = "destinatario_logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "destinatario_numero")
    private String numero;

    @NotBlank
    @Column(name="destinatario_complemento")
    private String complemento;

    @NotBlank
    @Column(name = "destinatario_bairro")
    private String bairro;
}

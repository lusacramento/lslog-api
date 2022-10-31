package com.lusacramento.lslog.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}

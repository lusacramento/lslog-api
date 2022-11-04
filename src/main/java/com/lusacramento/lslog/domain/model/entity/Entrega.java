package com.lusacramento.lslog.domain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Muitas entregas possuem 1 cliente
//    @JoinColumn(name = "cliente_id")  Caso a coluna do bd for outro nome, usar esta anotação
    private Cliente cliente;

    @Embedded // os dados desta entidade está contido na nesta tabela do banco de dados.
    private Destinatario destinatario;

    private BigDecimal taxa;

    @Enumerated(EnumType.STRING) // Anotação para escrever no tipo "string" e não índice (ordinal, número)
    private StatusEntrega status;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizacao;
}

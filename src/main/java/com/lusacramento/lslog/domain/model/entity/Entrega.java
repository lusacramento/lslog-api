package com.lusacramento.lslog.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumn(name = "cliente_id")  Caso a coluna do bd for outro nome, usar esta anotação
    @ManyToOne // Muitas entregas possuem 1 cliente
    private Cliente cliente;

    @Embedded // os dados desta entidade está contido na nesta tabela do banco de dados.
    private Destinatario destinatario;

    private BigDecimal taxa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING) // Anotação para escrever no tipo "string" e não índice (ordinal, número)
    private StatusEntrega status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;
}

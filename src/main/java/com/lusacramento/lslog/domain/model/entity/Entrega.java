package com.lusacramento.lslog.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lusacramento.lslog.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
    @NotNull
    @ManyToOne // Muitas entregas possuem 1 cliente
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    private Cliente cliente;

    @Valid
    @NotNull
    @Embedded // os dados desta entidade está contido na nesta tabela do banco de dados.
    private Destinatario destinatario;

    @NotNull
    private BigDecimal taxa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING) // Anotação para escrever no tipo "string" e não índice (ordinal, número)
    private StatusEntrega status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

   // @Transient  Não mapeia este campo na tabela do bd.
    // private String senha;
}

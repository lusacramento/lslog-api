package com.lusacramento.lslog.domain.model.dto;

import com.lusacramento.lslog.domain.model.entity.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDto {

    private Long id;

    private String nomeCliente;

    private DestinatarioModel destinatario;

    private BigDecimal taxa;

    private StatusEntrega status;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;
}

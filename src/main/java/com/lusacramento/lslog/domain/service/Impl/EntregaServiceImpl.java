package com.lusacramento.lslog.domain.service.Impl;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.model.entity.StatusEntrega;
import com.lusacramento.lslog.domain.repository.EntregaRepository;
import com.lusacramento.lslog.domain.service.EntregaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntregaServiceImpl implements EntregaService {

    private EntregaRepository entregaRepository;

    @Override
    public Entrega save(Entrega entrega) {
        // setando informações pré-definidas pelo sistema.
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}

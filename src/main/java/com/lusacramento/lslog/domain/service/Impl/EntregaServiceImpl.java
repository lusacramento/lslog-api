package com.lusacramento.lslog.domain.service.Impl;

import com.lusacramento.lslog.domain.exception.NegocioException;
import com.lusacramento.lslog.domain.model.entity.Cliente;
import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.model.entity.StatusEntrega;
import com.lusacramento.lslog.domain.repository.EntregaRepository;
import com.lusacramento.lslog.domain.service.ClienteService;
import com.lusacramento.lslog.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    ClienteService clienteService;

    @Override
    @Transactional
    public Entrega save(Entrega entrega) {
        // Buscando Id
        Cliente cliente = clienteService.findByIdwithExceptionResponse(entrega.getCliente().getId());

        // setando informações pré-definidas pelo sistema.
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}

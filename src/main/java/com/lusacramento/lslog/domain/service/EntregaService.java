package com.lusacramento.lslog.domain.service;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EntregaService {

    public Entrega save(Entrega entrega);

    List<Entrega> findAll();

    Optional<Entrega> findById(Long entregaId);
}

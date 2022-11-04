package com.lusacramento.lslog.domain.service;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import org.springframework.stereotype.Service;

@Service
public interface EntregaService {

    public Entrega save(Entrega entrega);
}

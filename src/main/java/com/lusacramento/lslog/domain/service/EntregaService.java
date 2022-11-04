package com.lusacramento.lslog.domain.service;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface EntregaService {

    public Entrega save(Entrega entrega);
}

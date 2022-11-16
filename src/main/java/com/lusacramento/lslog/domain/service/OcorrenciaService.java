package com.lusacramento.lslog.domain.service;

import com.lusacramento.lslog.domain.model.entity.Ocorrencia;
import org.springframework.stereotype.Service;

@Service
public interface OcorrenciaService {

    public Ocorrencia save(Long entregaId, String descricao);
}

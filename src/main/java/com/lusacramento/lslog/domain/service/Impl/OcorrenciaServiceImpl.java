package com.lusacramento.lslog.domain.service.Impl;

import com.lusacramento.lslog.domain.exception.EntidadeNaoEncontradaException;
import com.lusacramento.lslog.domain.exception.NegocioException;
import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.model.entity.Ocorrencia;
import com.lusacramento.lslog.domain.service.EntregaService;
import com.lusacramento.lslog.domain.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {
    @Autowired
    EntregaService entregaService;

    @Override
    @Transactional
    public Ocorrencia save(Long entregaId, String descricao) {
        Entrega entrega = entregaService.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(("Entrega não encontrada!")));

        return entrega.adicionarOcorrencia(descricao);
    }
}

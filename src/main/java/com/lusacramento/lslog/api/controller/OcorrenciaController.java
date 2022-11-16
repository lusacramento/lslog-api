package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.domain.exception.EntidadeNaoEncontradaException;
import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.model.entity.Ocorrencia;
import com.lusacramento.lslog.domain.service.EntregaService;
import com.lusacramento.lslog.domain.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @Autowired
    EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ocorrencia registrar(@PathVariable Long entregaId, @Valid @RequestBody Ocorrencia ocorrencia){
    return ocorrenciaService.save(entregaId, ocorrencia.getDescricao());
    }

    @GetMapping
    public Entrega findAll(@PathVariable Long entregaId){
        return entregaService.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}

package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.assembler.EntregaAssembler;
import com.lusacramento.lslog.domain.model.dto.EntregaDto;
import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private EntregaAssembler entregaAssembler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDto save(@Valid @RequestBody Entrega entrega){
        Entrega entregaSolicitada = entregaService.save(entrega);
        return entregaAssembler.toDto(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDto> findAll(){
        return entregaAssembler.toCollectionDto(entregaService.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> findById(@PathVariable Long entregaId){
        return entregaService.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toDto(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}

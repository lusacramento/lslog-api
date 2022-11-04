package com.lusacramento.lslog.api.controller;

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega save(@Valid @RequestBody Entrega entrega){
        return entregaService.save(entrega);
    }

    @GetMapping
    public List<Entrega> findAll(){
        return entregaService.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<Entrega> findById(@PathVariable Long entregaId){
        return entregaService.findById(entregaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




}

package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import com.lusacramento.lslog.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega save(@RequestBody Entrega entrega){
        return entregaService.save(entrega);
    }


}

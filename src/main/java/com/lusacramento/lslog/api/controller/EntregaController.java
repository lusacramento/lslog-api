package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.domain.model.dto.DestinatarioDto;
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
    public ResponseEntity<EntregaDto> findById(@PathVariable Long entregaId){
        return entregaService.findById(entregaId)
                .map(entrega -> {
                  EntregaDto entregaDto = new EntregaDto();
                  entregaDto.setId(entrega.getId());
                  entregaDto.setNomeCliente(entrega.getCliente().getNome());

                  entregaDto.setDestinatario( new DestinatarioDto());
                  entregaDto.getDestinatario().setNome(entrega.getDestinatario().getNome());
                  entregaDto.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                  entregaDto.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                  entregaDto.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                  entregaDto.getDestinatario().setBairro(entrega.getDestinatario().getBairro());

                  entregaDto.setTaxa(entrega.getTaxa());
                  entregaDto.setStatus(entrega.getStatus());
                  entregaDto.setDataPedido(entrega.getDataPedido());
                  entregaDto.setDataFinalizacao(entrega.getDataFinalizacao());

                  return ResponseEntity.ok(entregaDto);
                }).orElse(ResponseEntity.notFound().build());
    }




}

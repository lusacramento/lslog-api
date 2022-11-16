package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.domain.model.entity.Cliente;
import com.lusacramento.lslog.domain.repository.ClienteRepository;
import com.lusacramento.lslog.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> findById(@PathVariable Long clienteId) {
        return clienteService.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> update(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if (!clienteService.existsById(clienteId))
            return ResponseEntity.notFound().build();

        cliente.setId(clienteId);
        cliente = clienteService.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> delete(@PathVariable Long clienteId) {
        if (!clienteService.existsById(clienteId))
            return ResponseEntity.notFound().build();

        clienteService.deleteById(clienteId);

        return ResponseEntity.noContent().build();
    }
}

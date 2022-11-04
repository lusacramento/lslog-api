package com.lusacramento.lslog.domain.service;

import com.lusacramento.lslog.domain.model.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClienteService {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long clienteId);
    public Cliente save(Cliente cliente);
    public ResponseEntity<Cliente> update(Long clienteId, Cliente cliente);
    public void deleteById(Long clienteId);
    public boolean existsById(Long clienteId);


}

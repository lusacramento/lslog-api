package com.lusacramento.lslog.domain.service.Impl;

import com.lusacramento.lslog.domain.exception.NegocioException;
import com.lusacramento.lslog.domain.model.entity.Cliente;
import com.lusacramento.lslog.domain.repository.ClienteRepository;
import com.lusacramento.lslog.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long clienteId) {

        return clienteRepository. findById(clienteId);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente){
        boolean emailExistente = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailExistente) {
            throw new NegocioException("Já existe um cliente cadastrado com este email!");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public ResponseEntity<Cliente> update(Long clienteId, Cliente cliente) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long clienteId){
       clienteRepository.deleteById(clienteId);
    }

    @Override
    public boolean existsById(Long clienteId) {
        return clienteRepository.existsById(clienteId);
    }

    @Override
    public Cliente findByIdwithExceptionResponse(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }
}


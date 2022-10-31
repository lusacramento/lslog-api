package com.lusacramento.lslog.api.controller;

import com.lusacramento.lslog.domain.model.entity.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João da Silva");
        cliente1.setEmail("joaodasilva@lusacramento.com.br");
        cliente1.setTelefone("31977778888");
        Cliente cliente2 = new Cliente();

        cliente2.setId(cliente1.getId()+1);
        cliente2.setNome("Maria José");
        cliente2.setEmail("mariajose@lusacramento.com.br");
        cliente2.setTelefone("31966665555");

        return Arrays.asList(cliente1, cliente2);
    }
}

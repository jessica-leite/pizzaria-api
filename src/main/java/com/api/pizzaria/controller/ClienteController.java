package com.api.pizzaria.controller;

import com.api.pizzaria.models.Cliente;
import com.api.pizzaria.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/cadastro-cliente", method = RequestMethod.POST)
    private Cliente save(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @RequestMapping(value = "editar-cliente", method = RequestMethod.PUT)
    private Cliente update(@RequestBody Cliente cliente){
        boolean temCadastro = clienteRepository.existsById(cliente.getId());
        if(temCadastro){
            clienteRepository.save(cliente);
        } else {
            throw new ObjectNotFoundException("Cadastro de cliente não encontrado", cliente);
        }

        return cliente;
    }
}

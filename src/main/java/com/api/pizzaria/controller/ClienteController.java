package com.api.pizzaria.controller;

import com.api.pizzaria.models.Cliente;
import com.api.pizzaria.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        if(!temCadastro){
            throw new RuntimeException("Cliente não encontrado");
        }

        clienteRepository.save(cliente);
        return cliente;
    }

    @RequestMapping(value = "cliente/{id}", method = RequestMethod.GET)
    private Cliente findById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }

        return cliente.get();
    }

    @RequestMapping(value = "cliente/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Cliente deleteById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
        return cliente.get();
    }
}

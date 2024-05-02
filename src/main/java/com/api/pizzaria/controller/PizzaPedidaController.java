package com.api.pizzaria.controller;

import com.api.pizzaria.models.*;
import com.api.pizzaria.repositories.PedidoRepository;
import com.api.pizzaria.repositories.PizzaPedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PizzaPedidaController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PizzaPedidaRepository pizzaPedidaRepository;

    @RequestMapping(value = "cadastro-pizza-pedida", method = RequestMethod.POST)
    private PizzaPedida save(@RequestBody PizzaPedida pizzaPedida){

        pizzaPedida.getPedido().setDataHora(LocalDateTime.now());
        pedidoRepository.save(pizzaPedida.getPedido());
        pizzaPedidaRepository.save(pizzaPedida);

        return pizzaPedida;
    }

    @RequestMapping(value = "editar-pizza-pedida", method = RequestMethod.PUT)
    private PizzaPedida update(@RequestBody PizzaPedida pizzaPedida){
        boolean temCadastro = pizzaPedidaRepository.existsById(pizzaPedida.getId());
        if (!temCadastro){
            throw new RuntimeException("Pedido não encontrado");
        }

        pizzaPedida.getPedido().setDataHora(LocalDateTime.now());
        pedidoRepository.save(pizzaPedida.getPedido());
        pizzaPedidaRepository.save(pizzaPedida);

        return pizzaPedida;
    }

    @RequestMapping(value = "pizza-pedida/{id}", method = RequestMethod.GET)
    private PizzaPedida findById(@PathVariable Long id){
        Optional<PizzaPedida> pizzaPedida = pizzaPedidaRepository.findById(id);
        if(pizzaPedida.isEmpty()){
            throw new RuntimeException("Pedido não encontrado");
        }

        return pizzaPedida.get();
    }

    @RequestMapping(value = "pizza-pedida/{id}", method = RequestMethod.DELETE)
    private PizzaPedida deleteById(@PathVariable Long id){
        Optional<PizzaPedida> pizzaPedida = pizzaPedidaRepository.findById(id);
        if(pizzaPedida.isEmpty()){
            throw new RuntimeException("Pedido não encontrado");
        }

        pizzaPedidaRepository.deleteById(id);
        return pizzaPedida.get();
    }
}

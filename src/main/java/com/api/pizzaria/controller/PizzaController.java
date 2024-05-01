package com.api.pizzaria.controller;

import com.api.pizzaria.models.Pizza;
import com.api.pizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @RequestMapping(value = "cadastro-pizza", method = RequestMethod.POST)
    private Pizza save(@RequestBody Pizza pizza){
        pizzaRepository.save(pizza);

        return pizza;
    }

    @RequestMapping(value = "editar-pizza", method = RequestMethod.PUT)
    private Pizza update(@RequestBody Pizza pizza){
        boolean temCadastro = pizzaRepository.existsById(pizza.getId());
        if(!temCadastro){
            throw new RuntimeException("Pizza não encontrada");
        }

        pizzaRepository.save(pizza);
        return pizza;
    }

    @RequestMapping(value = "pizza/{id}", method = RequestMethod.GET)
    private Pizza findById(@PathVariable Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }

        return pizza.get();
    }

    @RequestMapping(value = "pizza/{id}", method = RequestMethod.DELETE)
    private Pizza deleteById(@PathVariable Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }

        pizzaRepository.deleteById(id);
        return pizza.get();
    }
}

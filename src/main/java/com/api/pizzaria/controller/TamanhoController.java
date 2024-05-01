package com.api.pizzaria.controller;

import com.api.pizzaria.models.Tamanho;
import com.api.pizzaria.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TamanhoController {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @RequestMapping(value = "cadastro-tamanho", method = RequestMethod.POST)
    private Tamanho save(@RequestBody Tamanho tamanho){
        tamanhoRepository.save(tamanho);
        return tamanho;
    }

    @RequestMapping(value = "editar-tamanho", method = RequestMethod.PUT)
    private Tamanho update(@RequestBody Tamanho tamanho){
        boolean temCadastro = tamanhoRepository.existsById(tamanho.getId());
        if(!temCadastro){
            throw new RuntimeException("Tamanho não encontrado");
        }

        tamanhoRepository.save(tamanho);
        return tamanho;
    }

    @RequestMapping(value = "tamanho/{id}")
    private Tamanho findById(@PathVariable Long id){
        Optional<Tamanho> tamanho = tamanhoRepository.findById(id);
        if(tamanho.isEmpty()){
            throw new RuntimeException("Tamanho não encontrado");
        }

        return tamanho.get();
    }

    @RequestMapping(value = "tamanho/{id}", method = RequestMethod.DELETE)
    private Tamanho deleteById(@PathVariable Long id){
        Optional<Tamanho> tamanho = tamanhoRepository.findById(id);
        if(tamanho.isEmpty()){
            throw new RuntimeException("Tamanho não encontrado");
        }

        tamanhoRepository.deleteById(id);
        return tamanho.get();
    }
}

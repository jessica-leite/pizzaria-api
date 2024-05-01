package com.api.pizzaria.repositories;

import com.api.pizzaria.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {
}

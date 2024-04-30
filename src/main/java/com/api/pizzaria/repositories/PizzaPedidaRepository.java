package com.api.pizzaria.repositories;

import com.api.pizzaria.models.PizzaPedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaPedidaRepository extends JpaRepository<PizzaPedida, Long> {
}

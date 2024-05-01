package com.api.pizzaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tamanho")
public class Tamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private double desconto;
}

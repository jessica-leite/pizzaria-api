package com.api.pizzaria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzaPedida")
public class PizzaPedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "pizzaId")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "tamanhoId")
    private Tamanho tamanho;

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}

package com.example;

public class Venda {
    private String produto;
    private double valor;

    // Construtor
    public Venda(String produto, double valor) {
        this.produto = produto;
        this.valor = valor;
    }

    // Getters
    public String getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    // Método toString
    @Override
    public String toString() {
        return "Venda{" +
                "produto='" + produto + '\'' +
                ", valor=" + valor +
                '}';
    }
}

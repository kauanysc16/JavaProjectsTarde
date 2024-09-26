package com.example;

public class Roupas extends Produto implements Transportavel {

    private double volume;
    private double peso;

public Roupas(String nome, double preco, double volume) {
super(nome, preco);
this.volume = volume;
}
    @Override
    public double calcularFrete() {
        double valorFrete = peso*5;
        return valorFrete;
    }

    @Override
    public double calcularPeso() {
        peso = volume * 10;
        return peso;
    }
    
    
}

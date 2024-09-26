package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Eletronico extends Produto implements Transportavel{

    private double volume;

    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        double peso = volume * 150;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double valorFrete = calcularPeso();
        return valorFrete;
    }

}

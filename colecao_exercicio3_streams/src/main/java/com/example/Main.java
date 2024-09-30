package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("Produto A", 150.00));
        vendas.add(new Venda("Produto B", 80.00));
        vendas.add(new Venda("Produto C", 200.00));
        vendas.add(new Venda("Produto D", 50.00));
        vendas.add(new Venda("Produto E", 120.00));

        double valorLimite = 100.00;

        List<Venda> vendasCaras = filtrarVendasCaras(vendas, valorLimite);
        System.out.println("Vendas acima de " + valorLimite + ": " + vendasCaras);

        calcularEstatisticasVendas(vendas);
    }

    public static List<Venda> filtrarVendasCaras(List<Venda> vendas, double limite) {
        return vendas.stream()
                .filter(venda -> venda.getValor() > limite)
                .collect(Collectors.toList()); // Usar collect para compatibilidade com Java 8+
    }

    public static void calcularEstatisticasVendas(List<Venda> vendas) {
        double totalVendas = vendas.stream()
                .mapToDouble(Venda::getValor)
                .sum();

        OptionalDouble mediaVendas = vendas.stream()
                .mapToDouble(Venda::getValor)
                .average();

        System.out.printf("Total de vendas: %.2f%n", totalVendas);
        System.out.printf("Valor médio das vendas: %.2f%n", mediaVendas.orElse(0.0));
    }
}

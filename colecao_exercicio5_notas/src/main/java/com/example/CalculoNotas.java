package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculoNotas {
    private Map<String, List<Double>> notasPorAluno = new HashMap<>();

    public void adicionarNotas(String nome, List<Double> notas) {
        notasPorAluno.put(nome, notas);
    }

    public <T extends Number> double calcularMedia(List<T> notas) {
        return notas.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(0.0);
    }

    public List<String> filtrarAlunosComMediaAcima(double mediaMinima) {
        return notasPorAluno.entrySet().stream()
                .filter(entry -> calcularMedia(entry.getValue()) > mediaMinima)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

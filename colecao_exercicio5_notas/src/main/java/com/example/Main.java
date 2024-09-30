package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculoNotas calculoNotas = new CalculoNotas();

        // Adicionar alunos e suas notas
        calculoNotas.adicionarNotas("Alice", Arrays.asList(8.5, 9.0, 7.5));
        calculoNotas.adicionarNotas("Bob", Arrays.asList(6.0, 7.0, 8.0));
        calculoNotas.adicionarNotas("Charlie", Arrays.asList(9.5, 10.0, 9.0));

        // Filtrar alunos com média acima de 8.0
        List<String> alunosComMediaAcimaDeOito = calculoNotas.filtrarAlunosComMediaAcima(8.0);
        System.out.println("Alunos com média acima de 8.0: " + alunosComMediaAcimaDeOito);
    }
}
package com.example;

import java.util.Scanner;

/**
 * Exercicio1SistemaNotas
 */
public class Exercicio1SistemaNotas {
    double[] notas = new double[4];
    double mediaNotas = 0;
    boolean bonus = true;

    Scanner sc = new Scanner(System.in);

    public void calculoNotas() {
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a nota " + i + ":");
            notas[i] = sc.nextDouble();
            mediaNotas += notas[i];
            if (notas[i] < 9) {
                bonus = false;
            }

        }
        mediaNotas /= notas.length;
        // aplicar o bonus
        if (bonus) {
            mediaNotas = (mediaNotas * 1.1 > 10 ? mediaNotas = 10 : mediaNotas * 1.1);
        }
        if (mediaNotas >= 7) {
            System.out.println("Aprovado");
        } else if (mediaNotas >= 5 && mediaNotas > 7) {
            System.err.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }
}
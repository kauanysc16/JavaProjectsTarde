package com.example;

import java.util.Scanner;

public class Exercicio3CalculadoraAvancada {
    double a;
    double b;
    double resultado;
    int escolha;

    Scanner sc = new Scanner(System.in);

    // soma
    public double somar(double a, double b) {
        return a + b;
    }

    // subtração
    public double subtrair(double a, double b) {
        return a - b;
    }

    // multiplicação
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // divisão
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Erro: Divisão por zero!");
        }
        return a / b;
    }

    // raiz
    public double raiz(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Não existe raiz de número negativo");
        }
        return Math.sqrt(a);
    }

    public void menu() {
        do {
            System.out.println("\n--- Calculadora Avançada ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();

            try {
                switch (escolha) {
                    case 1:
                        System.out.print("Digite o primeiro número: ");
                        a = sc.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        b = sc.nextDouble();
                        resultado = somar(a, b);
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 2:
                        System.out.print("Digite o primeiro número: ");
                        a = sc.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        b = sc.nextDouble();
                        resultado = subtrair(a, b);
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 3:
                        System.out.print("Digite o primeiro número: ");
                        a = sc.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        b = sc.nextDouble();
                        resultado = multiplicar(a, b);
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 4:
                        System.out.print("Digite o primeiro número: ");
                        a = sc.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        b = sc.nextDouble();
                        resultado = dividir(a, b);
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 5:
                        System.out.print("Digite um número: ");
                        a = sc.nextDouble();
                        resultado = raiz(a);
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Ocorreu um erro: " + e.getMessage());
            }
        } while (escolha != 0);
    }
}

package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Estacionamento estacionamento = new Estacionamento();

        Veiculo veiculo1 = new Veiculo("ABC-1234", 5.0);
        Veiculo veiculo2 = new Veiculo("XYZ-5678", 4.0);

        // Registrar entrada dos veículos
        estacionamento.registrarEntrada(veiculo1.getPlaca(), veiculo1);
        estacionamento.registrarEntrada(veiculo2.getPlaca(), veiculo2);

        // Simular espera de 3 horas
        Thread.sleep(3 * 60 * 60 * 1000); // 3 horas em milissegundos

        // Listar veículos que estão no estacionamento há mais de 2 horas
        List<String> veiculosMaisDeDuasHoras = estacionamento.listarVeiculosMaisDeDuasHoras();
        System.out.println("Veículos há mais de 2 horas no estacionamento: " + veiculosMaisDeDuasHoras);

        // Registrar saída de um veículo
        double valorPago = estacionamento.registrarSaida(veiculo1.getPlaca());
        System.out.printf("Valor a pagar para o veículo %s: R$ %.2f%n", veiculo1.getPlaca(), valorPago);
    }
}
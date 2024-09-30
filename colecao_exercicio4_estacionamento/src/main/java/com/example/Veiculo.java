package com.example;

public class Veiculo {
    private String placa;
    private double valorHora; // Valor por hora de estacionamento

    // Construtor
    public Veiculo(String placa, double valorHora) {
        this.placa = placa;
        this.valorHora = valorHora;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public double getValorHora() {
        return valorHora;
    }

    // Setters
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}

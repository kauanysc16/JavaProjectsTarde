package com.example;

import java.util.ArrayList;
import java.util.List;

class Aluno extends Pessoa {
    private String matricula;
    private List<Double> notas;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
        this.notas = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public String exibirInformacoes() {
        return "Aluno: " + getNome() + ", CPF: " + getCpf() + ", Matrícula: " + matricula + ", Média: " + calcularMedia();
    }

    public String avaliarDesempenho() {
        return calcularMedia() >= 7 ? "Aprovado" : "Reprovado";
    }
}
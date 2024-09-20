package com.example;

class Professor extends Pessoa {
    private double salario;

    public Professor(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String exibirInformacoes() {
        return "Professor: " + getNome() + ", CPF: " + getCpf() + ", Salário: " + salario;
    }

    public String avaliarDesempenho() {
        return "Desempenho avaliado.";
    }
}
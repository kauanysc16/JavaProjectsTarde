package com.example;

// Classe base Pessoa
class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String exibirInformacoes() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}

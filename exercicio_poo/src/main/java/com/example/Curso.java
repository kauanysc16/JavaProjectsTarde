package com.example;

import java.util.ArrayList;
import java.util.List;

class Curso {
    private String nome;
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String exibirInformacoes() {
        StringBuilder informacoes = new StringBuilder("Curso: " + nome + ", Professor: " + professor.exibirInformacoes() + "\nAlunos:\n");
        for (Aluno aluno : alunos) {
            informacoes.append(" - ").append(aluno.exibirInformacoes()).append("\n");
        }
        return informacoes.toString();
    }

    public double calcularMediaGeral() {
        return alunos.stream().mapToDouble(Aluno::calcularMedia).average().orElse(0);
    }

    public void statusAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome() + ": " + aluno.avaliarDesempenho());
        }
    }
}
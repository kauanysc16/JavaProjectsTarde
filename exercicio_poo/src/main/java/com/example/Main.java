package com.example;

public class Main {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Maria Silva", "123.456.789-00", 5000);
        Curso cursoPython = new Curso("Python para Iniciantes", professor1);

        Aluno aluno1 = new Aluno("João Santos", "987.654.321-00", "2021001");
        aluno1.adicionarNota(8);
        aluno1.adicionarNota(7);

        Aluno aluno2 = new Aluno("Ana Costa", "111.222.333-44", "2021002");
        aluno2.adicionarNota(6);
        aluno2.adicionarNota(5);

        cursoPython.adicionarAluno(aluno1);
        cursoPython.adicionarAluno(aluno2);

        System.out.println(cursoPython.exibirInformacoes());
        cursoPython.statusAlunos();
    }
}
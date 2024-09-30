package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca<Livro> biblioteca = new Biblioteca<>();

        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Bob");

        Livro livro1 = new Livro("O Senhor dos Anéis");
        Livro livro2 = new Livro("1984");
        Livro livro3 = new Livro("A Revolução dos Bichos");

        // Adicionando empréstimos
        biblioteca.adicionarEmprestimo(usuario1, livro1);
        biblioteca.adicionarEmprestimo(usuario1, livro2);
        biblioteca.adicionarEmprestimo(usuario2, livro2); // Deve mostrar que já está emprestado

        // Removendo um empréstimo
        biblioteca.removerEmprestimo(usuario1, livro1);

        // Listar itens emprestados
        System.out.println("Itens emprestados por Alice: " + biblioteca.listarItensEmprestados(usuario1));

        // Filtrando itens disponíveis
        List<Livro> todosOsLivros = new ArrayList<>(List.of(livro1, livro2, livro3));
        List<Livro> disponiveisParaAlice = biblioteca.filtrarItensDisponiveis(todosOsLivros, usuario1);
        System.out.println("Livros disponíveis para Alice: " + disponiveisParaAlice);
    }
}

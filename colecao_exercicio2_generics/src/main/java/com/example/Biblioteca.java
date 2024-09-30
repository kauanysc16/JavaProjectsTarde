package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Biblioteca<T> {
    private Map<Usuario, List<T>> emprestimos = new HashMap<>();

    public void adicionarEmprestimo(Usuario usuario, T item) {
        emprestimos.putIfAbsent(usuario, new ArrayList<>());
        List<T> itensEmprestados = emprestimos.get(usuario);
        if (!itensEmprestados.contains(item)) {
            itensEmprestados.add(item);
            System.out.println("Empréstimo adicionado: " + usuario + " pegou " + item);
        } else {
            System.out.println(usuario + " já possui o item " + item);
        }
    }

    public void removerEmprestimo(Usuario usuario, T item) {
        List<T> itensEmprestados = emprestimos.get(usuario);
        if (itensEmprestados != null && itensEmprestados.remove(item)) {
            System.out.println("Empréstimo removido: " + usuario + " devolveu " + item);
        } else {
            System.out.println(usuario + " não possui o item " + item);
        }
    }

    public List<T> listarItensEmprestados(Usuario usuario) {
        return emprestimos.getOrDefault(usuario, Collections.emptyList());
    }

    public List<T> filtrarItensDisponiveis(List<T> todosOsItens, Usuario usuario) {
        List<T> itensEmprestados = listarItensEmprestados(usuario);
        return todosOsItens.stream()
                .filter(item -> !itensEmprestados.contains(item))
                .collect(Collectors.toList());
    }
}
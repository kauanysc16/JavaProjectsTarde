package com.example;

// Importa as classes necessárias
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Classe que gerencia vendas de produtos associadas a CPFs
public class Vendas {
    // Mapa que relaciona um CPF a uma lista de produtos vendidos
    private Map<String, List<Produto>> vendasCPF;

    // Construtor que inicializa o mapa
    public Vendas() {
        vendasCPF = new HashMap<>();
    }

    // Método para cadastrar uma venda de um produto a um CPF
    public void cadastroVenda(String cpf, Produto p) {
        // Verifica se o CPF já existe no mapa
        for (String cpfUsuario : vendasCPF.keySet()) {
            if (cpfUsuario.equals(cpf)) {
                // Se existir, adiciona o produto à lista correspondente
                List<Produto> produtosCPF = vendasCPF.get(cpf);
                produtosCPF.add(p);
                vendasCPF.put(cpf, produtosCPF);
                return; // Sai do método após adicionar
            }
        }

        // Caso o CPF não exista, cria uma nova lista com o produto
        List<Produto> produtosCPFVazio = new ArrayList<>();
        produtosCPFVazio.add(p);
        vendasCPF.put(cpf, produtosCPFVazio);
    }

    // Método que lista os produtos associados a um CPF
    public List<Produto> listaProdutos(String cpf) {
        // Retorna a lista de produtos ou uma lista vazia se o CPF não existir
        return vendasCPF.getOrDefault(cpf, Collections.emptyList());
    }

    // Método para listar produtos filtrados por preço mínimo
    public List<Produto> listarProdutosFiltro(String cpf, double valorMinimo) throws Exception {
        // Obtém a lista de produtos do CPF ou uma lista vazia
        List<Produto> listaCpfFiltro = vendasCPF.getOrDefault(cpf, Collections.emptyList());
        if (listaCpfFiltro.isEmpty()) {
            // Lança uma exceção se não houver produtos para o CPF
            throw new Exception("CPF não encontrado");
        } else {
            // Filtra os produtos pelo preço mínimo e retorna a lista filtrada
            return listaCpfFiltro.stream()
                    .filter(p -> p.getPreco() >= valorMinimo)
                    .collect(Collectors.toList());
        }
    }
}

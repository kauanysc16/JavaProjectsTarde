package com.example;

import java.util.List; // Importa a classe List para gerenciar listas de produtos

import javax.swing.JOptionPane; // Importa a classe JOptionPane para interface gráfica

public class Main {
    public static void main(String[] args) {
        // Cria uma instância da classe Vendas para gerenciar vendas
        Vendas vendas = new Vendas();
        String operacao;

        // Loop principal para interação com o usuário
        do {
            // Exibe um menu de operações para o usuário
            operacao = JOptionPane.showInputDialog("----Gerenciamento de Vendas \n" +
                    "1- Cadastrar Venda \n" +
                    "2- Listar Vendas por CPF \n" +
                    "3- Listar Vendas por CPF e Valor Minimo \n" +
                    "4- Sair");

            // Verifica qual operação o usuário escolheu
            switch (operacao) {
                case "1":
                    // Cadastro de uma nova venda
                    String cpfCadastro = JOptionPane.showInputDialog("Informe o CPF:");
                    String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto:");
                    double precoProduto = Double
                            .parseDouble(JOptionPane.showInputDialog("Informe o preço do produto:"));
                    Produto produto = new Produto(nomeProduto, precoProduto);
                    vendas.cadastroVenda(cpfCadastro, produto);
                    JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
                    break;
                case "2":
                    // Listagem de vendas por CPF
                    String cpfLista = JOptionPane.showInputDialog("Informe o CPF para listar as vendas:");
                    List<Produto> produtosListados = vendas.listaProdutos(cpfLista);
                    StringBuilder sb = new StringBuilder();
                    if (produtosListados.isEmpty()) {
                        sb.append("Nenhum produto encontrado para o CPF informado.");
                    } else {
                        // Adiciona informações de cada produto à StringBuilder
                        for (Produto p : produtosListados) {
                            sb.append("Produto: ").append(p.getNome()).append(", Preço: ").append(p.getPreco())
                                    .append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                case "3":
                    // Listagem de vendas por CPF e valor mínimo
                    String cpfFiltro = JOptionPane.showInputDialog("Informe o CPF:");
                    double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor mínimo:"));
                    try {
                        List<Produto> produtosFiltrados = vendas.listarProdutosFiltro(cpfFiltro, valorMinimo);
                        StringBuilder sbFiltro = new StringBuilder();
                        if (produtosFiltrados.isEmpty()) {
                            sbFiltro.append("Nenhum produto encontrado para o CPF e valor mínimo informados.");
                        } else {
                            // Adiciona informações de cada produto filtrado à StringBuilder
                            for (Produto p : produtosFiltrados) {
                                sbFiltro.append("Produto: ").append(p.getNome()).append(", Preço: ")
                                        .append(p.getPreco()).append("\n");
                            }
                        }
                        JOptionPane.showMessageDialog(null, sbFiltro.toString());
                    } catch (Exception e) {
                        // Exibe mensagem de erro em caso de exceção
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case "4":
                    // Mensagem ao sair do programa
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    // Mensagem de operação inválida
                    JOptionPane.showMessageDialog(null, "Operação inválida!");
            }
        } while (!operacao.equals("4")); // Continua o loop até o usuário escolher sair
    }
}

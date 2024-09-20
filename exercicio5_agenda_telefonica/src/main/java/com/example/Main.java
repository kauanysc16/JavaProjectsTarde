package com.example;

import javax.swing.JOptionPane;

class Contato {
    String nome;
    String telefone;

    Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}

class AgendaTelefonica {
    private Contato[] contatos;
    private int contador;

    public AgendaTelefonica(int tamanho) {
        contatos = new Contato[tamanho];
        contador = 0;
    }

    public boolean adicionarContato(Contato contato) {
        if (contador < contatos.length) {
            contatos[contador++] = contato;
            return true;
        }
        return false;
    }

    public String listarContatos() {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            lista.append(i + 1).append(". ").append(contatos[i].nome).append(" - ").append(contatos[i].telefone)
                    .append("\n");
        }
        return lista.toString();
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato != null && contato.nome.equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public boolean removerContato(String nome) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].nome.equalsIgnoreCase(nome)) {
                contatos[i] = contatos[contador - 1]; // Move the last contact to the removed position
                contatos[--contador] = null; // Remove reference
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador = 0; // Initialize operador

        do {
            String menu = "\n--- Agenda Telefônica ---\n" +
                    "1 - Adicionar Contato\n" +
                    "2 - Listar Contatos\n" +
                    "3 - Buscar Contato (nome)\n" +
                    "4 - Remover Contato (nome)\n" +
                    "5 - Sair";

            String input = (String) JOptionPane.showInputDialog(null, menu, "Escolha uma operação",
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (input != null) {
                try {
                    operador = Integer.parseInt(input);

                    switch (operador) {
                        case 1:
                            String nome = JOptionPane.showInputDialog("Digite o Nome do Contato:");
                            String telefone = JOptionPane.showInputDialog("Digite o Telefone do Contato:");
                            if (nome != null && telefone != null) {
                                Contato contato = new Contato(nome, telefone);
                                if (agenda.adicionarContato(contato)) {
                                    JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Agenda cheia! Não foi possível adicionar contato.");
                                }
                            }
                            break;

                        case 2:
                            String contatosList = agenda.listarContatos();
                            if (contatosList.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum contato na agenda.");
                            } else {
                                JOptionPane.showMessageDialog(null, contatosList);
                            }
                            break;

                        case 3:
                            String nomeBusca = JOptionPane
                                    .showInputDialog("Digite o Nome do Contato que deseja buscar:");
                            Contato contatoEncontrado = agenda.buscarContato(nomeBusca);
                            if (contatoEncontrado != null) {
                                JOptionPane.showMessageDialog(null, "Contato encontrado: " + contatoEncontrado.nome
                                        + " - " + contatoEncontrado.telefone);
                            } else {
                                JOptionPane.showMessageDialog(null, "Contato não encontrado.");
                            }
                            break;

                        case 4:
                            String nomeRemocao = JOptionPane
                                    .showInputDialog("Digite o Nome do Contato que deseja remover:");
                            if (agenda.removerContato(nomeRemocao)) {
                                JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Contato não encontrado.");
                            }
                            break;

                        case 5:
                            JOptionPane.showMessageDialog(null, "Saindo...");
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
                }
            }
        } while (operador != 5);
    }
}

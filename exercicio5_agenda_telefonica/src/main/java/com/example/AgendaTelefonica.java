package com.example;

public class AgendaTelefonica {

    private Contato[] contatos;
    private int contador;

    public AgendaTelefonica(int maxContato) {
        contatos = new Contato[maxContato];
        contador = 0;
    }

    // métodos
    // add
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contador >= contatos.length) {
            throw new AgendaCheiaException("Agenda Cheia");
        }
        contatos[contador] = contato;
        contador++;
        System.out.println("Contato Adicionado com Sucesso");

    }

    // listar
    public void listarContato() {
        if (contador == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }
        // buscar
        public Contato buscarContato(String nome) {
            for (Contato contato : contatos) {
                if (contato != null && contato.nome.equalsIgnoreCase(nome)) {
                    return contato;
                }
            }
            return null;
        }
        // remover
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

    boolean adicionarContato(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
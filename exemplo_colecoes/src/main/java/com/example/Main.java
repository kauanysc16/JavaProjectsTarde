package com.example;

public class Main {
    public static void main(String[] args) {
        ListExemplo list = new ListExemplo();
        list.addNome("Maria");
        list.addNome("João");
        list.addNome("Pedro");
        list.listarNomes();
        list.modificarNome("Pedro", "Maria");
        list.listarNomes();
        list.removerNome("Maria");
        list.listarNomes();
        SetExemplo set = new SetExemplo();
        set.addNome("Maria");
        set.addNome("João");
        set.addNome("Pedro");
        set.listarNomes();
        //adicionar Maria
        set.addNome("Maria");
        set.listarNomes();
        set.removerNome("Maria");
        set.listarNomes();
    }
}
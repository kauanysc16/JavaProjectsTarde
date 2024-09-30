package com.example;

// Importa as anotações do Lombok para reduzir o código boilerplate
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotação que gera um construtor sem argumentos
@NoArgsConstructor
// Anotação que gera um construtor com todos os argumentos
@AllArgsConstructor
// Anotações que geram métodos getter e setter para todos os campos
@Getter
@Setter
public class Produto {
    // Atributo que representa o nome do produto
    private String nome;
    // Atributo que representa o preço do produto
    private double preco;
}

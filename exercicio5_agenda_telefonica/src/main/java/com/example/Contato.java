package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Contato {
    String nome;
    private String telefone;   

public String toString() {
return "Nome: " + nome + ", telefone: " + telefone;
}
}

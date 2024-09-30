package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class Aluno {
    private String nome;
    private List<Double> notas;
}
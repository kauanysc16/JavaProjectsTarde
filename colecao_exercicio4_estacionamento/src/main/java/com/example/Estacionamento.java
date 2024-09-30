package com.example;

import lombok.Getter;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Getter
public class Estacionamento {
    private final Map<String, LocalDateTime> registroEntrada = new HashMap<>();
    private final Map<String, Veiculo> veiculos = new HashMap<>();

    public void registrarEntrada(@NonNull String placa, @NonNull Veiculo veiculo) {
        registroEntrada.put(placa, LocalDateTime.now());
        veiculos.put(placa, veiculo);
    }

    public double registrarSaida(@NonNull String placa) {
        LocalDateTime entrada = registroEntrada.get(placa);
        if (entrada == null) {
            throw new IllegalArgumentException("Veículo não encontrado.");
        }
        LocalDateTime agora = LocalDateTime.now();
        Duration duracao = Duration.between(entrada, agora);
        double valorAPagar = duracao.toHours() * veiculos.get(placa).getValorHora();

        // Remover o veículo do registro
        registroEntrada.remove(placa);
        veiculos.remove(placa);
        
        return valorAPagar;
    }

    public List<String> listarVeiculosMaisDeDuasHoras() {
        LocalDateTime agora = LocalDateTime.now();
        return registroEntrada.entrySet().stream()
                .filter(entry -> Duration.between(entry.getValue(), agora).toHours() > 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

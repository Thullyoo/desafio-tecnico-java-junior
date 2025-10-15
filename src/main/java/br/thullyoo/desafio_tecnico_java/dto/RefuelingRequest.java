package br.thullyoo.desafio_tecnico_java.dto;

import java.math.BigDecimal;

public record RefuelingRequest(Long fuelPumpId, BigDecimal amount, Long liters) {
}

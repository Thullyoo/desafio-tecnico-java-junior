package br.thullyoo.desafio_tecnico_java.dto;

import java.math.BigDecimal;

public record FuelTypeRequest(String name, BigDecimal pricePerLiter) {
}

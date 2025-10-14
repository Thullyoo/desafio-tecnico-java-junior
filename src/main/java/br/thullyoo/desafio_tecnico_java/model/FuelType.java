package br.thullyoo.desafio_tecnico_java.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "TB_FUEL_TYPE")
@Entity
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal pricePerLiter;

    public FuelType() {
    }

    public FuelType(String name, BigDecimal pricePerLiter) {
        this.name = name;
        this.pricePerLiter = pricePerLiter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(BigDecimal pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }
}

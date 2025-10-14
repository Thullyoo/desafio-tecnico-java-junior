package br.thullyoo.desafio_tecnico_java.model.refueling;

import br.thullyoo.desafio_tecnico_java.model.fuelpump.FuelPump;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "TB_REFUELING")
@Entity
public class Refueling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fuel_pump_id", nullable = false)
    private FuelPump fuelPump;

    @CreationTimestamp
    private LocalDateTime refuelingDate;

    private BigDecimal amount;

    private Long liters;

    public Refueling() {
    }

    public Refueling(FuelPump fuelPump, BigDecimal amount, Long liters) {
        this.fuelPump = fuelPump;
        this.amount = amount;
        this.liters = liters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FuelPump getFuelPump() {
        return fuelPump;
    }

    public void setFuelPump(FuelPump fuelPump) {
        this.fuelPump = fuelPump;
    }

    public LocalDateTime getRefuelingDate() {
        return refuelingDate;
    }

    public void setRefuelingDate(LocalDateTime refuelingDate) {
        this.refuelingDate = refuelingDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getLiters() {
        return liters;
    }

    public void setLiters(Long liters) {
        this.liters = liters;
    }
}

package br.thullyoo.desafio_tecnico_java.services;

import br.thullyoo.desafio_tecnico_java.dto.RefuelingRequest;
import br.thullyoo.desafio_tecnico_java.model.Refueling;
import br.thullyoo.desafio_tecnico_java.repositories.FuelPumpRepository;
import br.thullyoo.desafio_tecnico_java.repositories.RefuelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefuelingService {

    @Autowired
    private RefuelingRepository refuelingRepository;

    @Autowired
    private FuelPumpRepository fuelPumpRepository;

    public Refueling save(RefuelingRequest refuelingRequest) {
        if (!fuelPumpRepository.existsById(refuelingRequest.fuelPumpId())) {
            throw new IllegalArgumentException("Fuel pump not found");
        }

        Refueling refueling = new Refueling();
        refueling.setFuelPump(fuelPumpRepository.findById(refuelingRequest.fuelPumpId()).get());
        refueling.setAmount(refuelingRequest.amount());
        refueling.setLiters(refuelingRequest.liters());

        return refuelingRepository.save(refueling);
    }

    public void deleteById(Long id) {
        if (!refuelingRepository.existsById(id)) {
            throw new IllegalArgumentException("Refueling not found");
        }
        refuelingRepository.deleteById(id);
    }

    public Refueling getById(Long id) {
        return refuelingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Refueling not found"));
    }

    public List<Refueling> getAll() {
        return refuelingRepository.findAll();
    }

    public Refueling update(Long id, RefuelingRequest refuelingRequest) {
        Refueling existingRefueling = refuelingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Refueling not found"));

        if (!fuelPumpRepository.existsById(refuelingRequest.fuelPumpId())) {
            throw new IllegalArgumentException("Fuel pump not found");
        }

        existingRefueling.setFuelPump(fuelPumpRepository.findById(refuelingRequest.fuelPumpId()).get());
        existingRefueling.setAmount(refuelingRequest.amount());
        existingRefueling.setLiters(refuelingRequest.liters());

        return refuelingRepository.save(existingRefueling);
    }
}

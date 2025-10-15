package br.thullyoo.desafio_tecnico_java.services;

import br.thullyoo.desafio_tecnico_java.dto.FuelPumpRequest;
import br.thullyoo.desafio_tecnico_java.model.FuelPump;
import br.thullyoo.desafio_tecnico_java.repositories.FuelPumpRepository;
import br.thullyoo.desafio_tecnico_java.repositories.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelPumpService {

    @Autowired
    private FuelPumpRepository fuelPumpRepository;

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public FuelPump save(FuelPumpRequest fuelPumpRequest) {
        if (!fuelTypeRepository.existsById(fuelPumpRequest.fuelTypeId())){
            throw new IllegalArgumentException("Fuel type not found");
        }
        FuelPump fuelPump = new FuelPump();
        fuelPump.setName(fuelPumpRequest.name());
        fuelPump.setFuelType(fuelTypeRepository.findById(fuelPumpRequest.fuelTypeId()).get());
        return fuelPumpRepository.save(fuelPump);
    }

    public void deleteById(Long id) {
        fuelPumpRepository.deleteById(id);
    }

    public FuelPump update(Long id, FuelPumpRequest fuelPumpRequest) {
        FuelPump existingFuelPump = fuelPumpRepository.findById(id).orElse(null);
        if (existingFuelPump != null) {
            if (!fuelTypeRepository.existsById(fuelPumpRequest.fuelTypeId())){
                throw new IllegalArgumentException("Fuel type not found");
            }
            existingFuelPump.setName(fuelPumpRequest.name());
            existingFuelPump.setFuelType(fuelTypeRepository.findById(fuelPumpRequest.fuelTypeId()).get());
            return fuelPumpRepository.save(existingFuelPump);
        }
        return null;
    }

    public List<FuelPump> findAll() {
        return fuelPumpRepository.findAll();
    }

    public FuelPump findById(Long id) {
        return fuelPumpRepository.findById(id).orElse(null);
    }
}


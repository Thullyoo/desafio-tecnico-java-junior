package br.thullyoo.desafio_tecnico_java.services;

import br.thullyoo.desafio_tecnico_java.model.FuelType;
import br.thullyoo.desafio_tecnico_java.repositories.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    public FuelType save(FuelType fuelType) {
        return fuelTypeRepository.save(fuelType);
    }

    public List<FuelType> findAll() {
        return fuelTypeRepository.findAll();
    }

    public FuelType findById(Long id) {
        return fuelTypeRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        fuelTypeRepository.deleteById(id);
    }

    public FuelType update(Long id, FuelType fuelType) {
        FuelType existingFuelType = fuelTypeRepository.findById(id).orElse(null);
        if (existingFuelType != null) {
            existingFuelType.setName(fuelType.getName());
            existingFuelType.setPricePerLiter(fuelType.getPricePerLiter());
            return fuelTypeRepository.save(existingFuelType);
        }
        return null;
    }

}

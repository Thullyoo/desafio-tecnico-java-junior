package br.thullyoo.desafio_tecnico_java.controller;

import br.thullyoo.desafio_tecnico_java.dto.FuelTypeRequest;
import br.thullyoo.desafio_tecnico_java.model.FuelType;
import br.thullyoo.desafio_tecnico_java.services.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuel-types")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @PostMapping
    public ResponseEntity<FuelType> create(@RequestBody FuelTypeRequest fuelTypeRequest) {
        FuelType fuelType = new FuelType();
        fuelType.setName(fuelTypeRequest.name());
        fuelType.setPricePerLiter(fuelTypeRequest.pricePerLiter());
        FuelType saved = fuelTypeService.save(fuelType);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<FuelType>> getAll() {
        return ResponseEntity.ok(fuelTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelType> getById(@PathVariable Long id) {
        FuelType fuelType = fuelTypeService.findById(id);
        if (fuelType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fuelType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelType> update(@PathVariable Long id, @RequestBody FuelTypeRequest fuelTypeRequest) {
        FuelType updated = new FuelType();
        updated.setName(fuelTypeRequest.name());
        updated.setPricePerLiter(fuelTypeRequest.pricePerLiter());

        FuelType result = fuelTypeService.update(id, updated);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fuelTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


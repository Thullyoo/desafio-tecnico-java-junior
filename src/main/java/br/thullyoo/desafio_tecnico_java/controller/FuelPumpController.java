package br.thullyoo.desafio_tecnico_java.controller;

import br.thullyoo.desafio_tecnico_java.dto.FuelPumpRequest;
import br.thullyoo.desafio_tecnico_java.model.FuelPump;
import br.thullyoo.desafio_tecnico_java.services.FuelPumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuel-pumps")
public class FuelPumpController {

    @Autowired
    private FuelPumpService fuelPumpService;

    @PostMapping
    public ResponseEntity<FuelPump> create(@RequestBody FuelPumpRequest fuelPumpRequest) {
        FuelPump fuelPump = fuelPumpService.save(fuelPumpRequest);
        return ResponseEntity.ok(fuelPump);
    }

    @GetMapping
    public ResponseEntity<List<FuelPump>> getAll() {
        return ResponseEntity.ok(fuelPumpService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelPump> getById(@PathVariable Long id) {
        FuelPump fuelPump = fuelPumpService.findById(id);
        if (fuelPump == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fuelPump);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelPump> update(@PathVariable Long id, @RequestBody FuelPumpRequest fuelPumpRequest) {
        FuelPump updated = fuelPumpService.update(id, fuelPumpRequest);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fuelPumpService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


package br.thullyoo.desafio_tecnico_java.controller;

import br.thullyoo.desafio_tecnico_java.dto.RefuelingRequest;
import br.thullyoo.desafio_tecnico_java.model.Refueling;
import br.thullyoo.desafio_tecnico_java.services.RefuelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refuelings")
public class RefuelingController {

    @Autowired
    private RefuelingService refuelingService;

    @PostMapping
    public ResponseEntity<Refueling> create(@RequestBody RefuelingRequest refuelingRequest) {
        Refueling refueling = refuelingService.save(refuelingRequest);
        return ResponseEntity.ok(refueling);
    }

    @GetMapping
    public ResponseEntity<List<Refueling>> getAll() {
        return ResponseEntity.ok(refuelingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refueling> getById(@PathVariable Long id) {
        try {
            Refueling refueling = refuelingService.getById(id);
            return ResponseEntity.ok(refueling);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refueling> update(@PathVariable Long id, @RequestBody RefuelingRequest refuelingRequest) {
        try {
            Refueling updated = refuelingService.update(id, refuelingRequest);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            refuelingService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


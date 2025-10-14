package br.thullyoo.desafio_tecnico_java.repositories;

import br.thullyoo.desafio_tecnico_java.model.FuelPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelPumpRepository extends JpaRepository<FuelPump, Long> {
}

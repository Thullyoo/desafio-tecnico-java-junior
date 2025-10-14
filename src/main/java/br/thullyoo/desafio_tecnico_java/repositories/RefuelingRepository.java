package br.thullyoo.desafio_tecnico_java.repositories;

import br.thullyoo.desafio_tecnico_java.model.refueling.Refueling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefuelingRepository extends JpaRepository<Refueling, Long> {
}

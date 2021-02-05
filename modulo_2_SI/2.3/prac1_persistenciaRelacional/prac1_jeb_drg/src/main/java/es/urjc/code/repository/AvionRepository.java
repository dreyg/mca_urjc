package es.urjc.code.repository;

import es.urjc.code.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {

}

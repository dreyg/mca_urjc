package es.urjc.code.repository;

import es.urjc.code.models.Aeropuerto;
import es.urjc.code.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

}

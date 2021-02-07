package es.urjc.code.repository;

import es.urjc.code.models.Mecanico;
import es.urjc.code.models.VueloTripulante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloTripulanteRepository extends JpaRepository<VueloTripulante, Long> {

}

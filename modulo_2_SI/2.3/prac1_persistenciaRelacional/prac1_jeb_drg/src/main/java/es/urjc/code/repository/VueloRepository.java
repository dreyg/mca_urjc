package es.urjc.code.repository;

import es.urjc.code.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}

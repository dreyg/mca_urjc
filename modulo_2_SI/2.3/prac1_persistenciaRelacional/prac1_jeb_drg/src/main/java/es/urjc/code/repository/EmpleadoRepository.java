package es.urjc.code.repository;

import es.urjc.code.models.Empleado;
import es.urjc.code.models.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}

package es.urjc.code.repository;

import es.urjc.code.dto.MecanicoRevisionDTO;
import es.urjc.code.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvionRepository extends JpaRepository<Avion, Long> {


    @Query("SELECT new es.urjc.code.dto.MecanicoRevisionDTO(a.codAvion, m.nombre, m.apellidos) FROM Avion a, Revision r, Mecanico m " +
            "WHERE a.id = r.avion.id AND r.mecanico.id = m.id")
    List<MecanicoRevisionDTO> findAllMecanicosRevisiones();


}

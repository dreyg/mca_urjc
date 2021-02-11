package es.urjc.code.repository;

import es.urjc.code.dto.MecanicoRevisionDTO;
import es.urjc.code.dto.TripulanteEstadisticasDTO;
import es.urjc.code.dto.TripulanteViajesDTO;
import es.urjc.code.models.Tripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {


    @Query("SELECT new es.urjc.code.dto.TripulanteViajesDTO(t.codEmpleado, t.nombre, t.apellidos, a.ciudad, v.fechaHoraSalida) " +
            "FROM Tripulante t, Vuelo v, VueloTripulante  vt, Aeropuerto a " +
            "WHERE t.id = vt.tri.id AND vt.vue.id = v.id AND v.aeropuertoOrigen.id = a.id AND t.codEmpleado =?1")
    List<TripulanteViajesDTO> findByCodEmpleadoViajes(String codEmpleado);


    @Query("SELECT new es.urjc.code.dto.TripulanteEstadisticasDTO(t.nombre, t.apellidos, COUNT(v.duracionVuelo), SUM(v.duracionVuelo))" +
            "FROM Tripulante t, Vuelo v, VueloTripulante  vt" +
            " WHERE t.id = vt.tri.id AND vt.vue.id = v.id GROUP BY t.id")
    List<TripulanteEstadisticasDTO> findAllTripulantesEstadisticas();


}

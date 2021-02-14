package es.urjc.code.repository;

import es.urjc.code.dto.TripulanteEstadisticasDTO;
import es.urjc.code.dto.TripulanteViajesDTO;
import es.urjc.code.models.Tripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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


    @Query(value = "SELECT t.codEmpleado, t.nombre, t.apellidos " +
            "FROM test.avion a, \n" +
            "     JSON_TABLE(a.revisionjson, '$[*].mecanico_id' COLUMNS (\n" +
            "                mecanico_id varchar(40)  PATH '$')\n" +
            "     ) mr, mecanico m \n" +
            "WHERE mr.mecanico_id = m.id\n" +
            "order by cod_avion",
            nativeQuery = true)
    List<TripulanteViajesDTO> findCodEmpleadoViajesJSON();


    @Query(value = "SELECT t.nombre, t.apellidos, COUNT(v.duracionVuelo), SUM(v.duracionVuelo)" +
            "FROM test.vuelo v,\n" +
            "    JSON_TABLE(v.tripulantesjson, '$[*]' COLUMNS (\n" +
            "                tripulante_id varchar(40)  PATH '$')\n" +
            "     ) tri, tripulante t \n" +
            "WHERE tri.tripulante_id = t.id\n" +
            "GROUP BY tri.tripulante_id",nativeQuery = true)
    List<TripulanteEstadisticasDTO> findAllTripulantesEstadisticasJSON();

}

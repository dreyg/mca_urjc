package es.urjc.code.repository;

import es.urjc.code.dto.TripulanteViajesDTO;
import es.urjc.code.dto.VuelosAeropuertoDTO;
import es.urjc.code.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {


    @Query("SELECT new es.urjc.code.dto.VuelosAeropuertoDTO(v.codVuelo, a.ciudad, a.codAeropuerto, v.fechaHoraSalida, v.duracionVuelo)" +
            "FROM Vuelo v, Aeropuerto a " +
            "WHERE v.aeropuertoDestino.id = a.id AND a.ciudad = ?1")
    List<VuelosAeropuertoDTO> findByCiudadAllVuelos(String ciudad);

}

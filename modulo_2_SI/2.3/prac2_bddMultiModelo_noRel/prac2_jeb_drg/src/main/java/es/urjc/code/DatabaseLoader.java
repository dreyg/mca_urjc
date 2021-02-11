package es.urjc.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.urjc.code.dto.MecanicoRevisionDTO;
import es.urjc.code.dto.TripulanteEstadisticasDTO;
import es.urjc.code.dto.TripulanteViajesDTO;
import es.urjc.code.dto.VuelosAeropuertoDTO;
import es.urjc.code.models.*;
import es.urjc.code.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * Cargador de la BD y ejemplos de consulta.
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired private AeropuertoRepository aeropuertoRepository;
    @Autowired private AvionRepository avionRepository;
    @Autowired private MecanicoRepository mecanicoRepository;
    @Autowired private RevisionRepository revisionRepository;
    @Autowired private TripulanteRepository tripulanteRepository;
    @Autowired private VueloRepository vueloRepository;
    @Autowired private EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) {



        // -- query 1 Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones
        List<MecanicoRevisionDTO> mecanicoRevisionDTOList = avionRepository.findAllMecanicosRevisiones();
        System.out.println("----------------------------------------");
        System.out.println("Aviones con findAllMecanicosRevisiones():");
        System.out.println("----------------------------------------");
        muestraDatosRevision(mecanicoRevisionDTOList);

        // QUERY 2 Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los
        // aeropuertos de esa ciudad en esa fecha, ordenados por fecha -- Param -> Ciudad = Barcelona
        List<VuelosAeropuertoDTO> vuelosAeropuertoDTOList = vueloRepository.findByCiudadAllVuelos("Barcelona");
        System.out.println("----------------------------------------");
        System.out.println("Tripulantes con findByCiudadAndFechaAllVuelos():");
        System.out.println("----------------------------------------");
        muestraDatosVuelosAeropuerto(vuelosAeropuertoDTOList);

        // QUERY 3 Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde
        // las que ha despegado junto con la fecha en que despegó.
        // Param entrada: Código tripulante
        List<TripulanteViajesDTO> tripulanteViajesDTOList = tripulanteRepository.findByCodEmpleadoViajes("COM001");
        System.out.println("----------------------------------------");
        System.out.println("Tripulantes con findByCodEmpleadoViajes(COM001):");
        System.out.println("----------------------------------------");
        muestraDatosTripulante(tripulanteViajesDTOList);

        // QUERY 4 Para cada tripulante, mostrar su nombre y apellidos junto
        // con su número total de vuelos y la suma de horas de estos.
        List<TripulanteEstadisticasDTO> tripulanteEstadisticasDTOList = tripulanteRepository.findAllTripulantesEstadisticas();
        System.out.println("----------------------------------------");
        System.out.println("Tripulantes con tripulanteEstadisticasDTOList():");
        System.out.println("----------------------------------------");
        muestraDatosTripulanteEstadisticas(tripulanteEstadisticasDTOList);

    }

    private static void muestraDatosRevision(List<MecanicoRevisionDTO> datos) {
        for (MecanicoRevisionDTO p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

    private static void muestraDatosVuelosAeropuerto(List<VuelosAeropuertoDTO> datos) {
        for (VuelosAeropuertoDTO p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }


    private static void muestraDatosTripulante(List<TripulanteViajesDTO> datos) {
        for (TripulanteViajesDTO p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

    private static void muestraDatosTripulanteEstadisticas(List<TripulanteEstadisticasDTO> datos) {
        for (TripulanteEstadisticasDTO p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

}

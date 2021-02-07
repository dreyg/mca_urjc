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


        // Lita de vuelos vacía;
        List<Vuelo> sinVuelos = new ArrayList<>();

        //Lista de revisiones vacía
        List<Revision> sinRevisiones = new ArrayList<>();




        Tripulante trip1 = new Tripulante("COM001","Alberto","Lopez Frau","Comanadante","IBERIA");
        Tripulante trip2 = new Tripulante("COM002","Alvaro","Fernandez Lopez","Co-Piloto","IBERIA");
        Tripulante trip3 = new Tripulante("COM003","Antonio","Gonzalez Ruiz","Sobrecargo","IBERIA");
        Tripulante trip4 = new Tripulante("COM004","Juan","Gomez Sanchez","Comanadante","IBERIA");
        Tripulante trip5 = new Tripulante("COM005","Pedro","Jimenez Diaz","Co-Piloto","IBERIA");
        Tripulante trip6 = new Tripulante("COM006","David","Robledo Chavela","Sobrecargo","IBERIA");


        Avion avion1 = avionRepository.save(new Avion("BOI001", "Boing", "Boing 737", 2500, sinVuelos, sinRevisiones));
        Avion avion2 = avionRepository.save(new Avion("BOI002", "Boing", "Boing 777", 1500, sinVuelos, sinRevisiones));
        Avion avion3 = avionRepository.save(new Avion("BOI003", "Boing", "Boing 767", 5500, sinVuelos, sinRevisiones));
        Avion avion4 = avionRepository.save(new Avion("AIR001", "Airbus", "A340", 2500, sinVuelos, sinRevisiones));
        Avion avion5 = avionRepository.save(new Avion("AVI002", "Airbus", "A380", 4500, sinVuelos, sinRevisiones));
        Avion avion6 = avionRepository.save(new Avion("AVI003", "Airbus", "A400", 6500, sinVuelos, sinRevisiones));

        Mecanico meca1 = new Mecanico("MEC001","Roberto","Ruiz Garcia","Airbus",1995,"", sinRevisiones);
        Mecanico meca2 = new Mecanico("MEC002","Rebeca","Tola Cruz","Airbus",1992,"", sinRevisiones);
        Mecanico meca3 = new Mecanico("MEC003","Ruben","Muñoz Rodriguez","Airbus",1998,"", sinRevisiones);
        Mecanico meca4 = new Mecanico("MEC004","Ramon","Lopez Perez","Airbus",2005,"", sinRevisiones);

        empleadoRepository.save(meca1);
        empleadoRepository.save(meca2);
        empleadoRepository.save(meca3);
        empleadoRepository.save(meca4);


        Aeropuerto aero1 = aeropuertoRepository.save(new Aeropuerto("MAD01","Barajas","Madrid","España",sinVuelos, sinRevisiones));
        Aeropuerto aero2 = aeropuertoRepository.save(new Aeropuerto("MAD02","Cuatro Vientos","Madrid","España",sinVuelos, sinRevisiones));
        Aeropuerto aero3 = aeropuertoRepository.save(new Aeropuerto("BAR01","El prat","Barcelona","España",sinVuelos, sinRevisiones));



        Vuelo vuelo1 = new Vuelo("IBE001","Iberia",new Date(System.currentTimeMillis()-10000000), 0.45f, avion1, aero1, aero3);
        Vuelo vuelo2 = new Vuelo("IBE002","Iberia",new Date(System.currentTimeMillis()-20000000),0.45f, avion2, aero2, aero3);

        List <VueloTripulante> rels = new ArrayList<>();
        VueloTripulante v1t1 = new VueloTripulante(vuelo1,trip1);
        VueloTripulante v1t2 = new VueloTripulante(vuelo1,trip2);
        VueloTripulante v1t3 = new VueloTripulante(vuelo1,trip3);

        rels.add(v1t1);
        rels.add(v1t2);
        rels.add(v1t3);

        List <VueloTripulante> rels2 = new ArrayList<>();
        VueloTripulante v2t4 = new VueloTripulante(vuelo2,trip4);
        VueloTripulante v2t5 = new VueloTripulante(vuelo2,trip5);
        VueloTripulante v2t6 = new VueloTripulante(vuelo2,trip6);

        rels2.add(v2t4);
        rels2.add(v2t5);
        rels2.add(v2t6);

        vuelo1.setTripulantes(rels);
        vuelo2.setTripulantes(rels2);

        vueloRepository.save(vuelo1);
        vueloRepository.save(vuelo2);


        /*Vuelo vuelo1 = vueloRepository.save(new Vuelo("IBE001","Iberia",new Date(System.currentTimeMillis()-10000000),tripulantes, avion1, aero1, aero3));
        Vuelo vuelo2 = vueloRepository.save(new Vuelo("IBE002","Iberia",new Date(System.currentTimeMillis()-20000000),tripulantes, avion2, aero2, aero3));
        Vuelo vuelo3 = vueloRepository.save(new Vuelo("RYN001","RyanAir",new Date(System.currentTimeMillis()-30000000),tripulantes, avion3, aero3, aero1));
        Vuelo vuelo4 = vueloRepository.save(new Vuelo("VUE001","Vueling",new Date(System.currentTimeMillis()-40000000),tripulantes, avion4, aero3, aero2));
        Vuelo vuelo5 = vueloRepository.save(new Vuelo("VUE002","Vueling",new Date(System.currentTimeMillis()-50000000),tripulantes, avion5, aero1, aero3));*/


        Revision rev1 = revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-150000000),new Date(System.currentTimeMillis()-10000), 15, "periodica","cambio de aceite y revisión del motor",avion1,meca1, aero1));
        Revision rev2 =  revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-250000000),new Date(System.currentTimeMillis()-20000), 20, "periodica","revisión del motor e interiores", avion2, meca2, aero2));
        Revision rev3 = revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-350000000),new Date(System.currentTimeMillis()-30000), 25, "periodica","interiores y cabina", avion3, meca3, aero3));
        Revision rev4 = revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-450000000),new Date(System.currentTimeMillis()-40000), 30, "reparacion","cabina y asientos", avion4, meca4, aero1));
        Revision rev5 = revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-550000000),new Date(System.currentTimeMillis()-50000), 35, "reparacion","reparacion exteriores", avion5, meca1, aero2));
        Revision rev6 = revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-650000000),new Date(System.currentTimeMillis()-60000), 40, "reparacion","sustitucion caja negra", avion6, meca2, aero3));


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

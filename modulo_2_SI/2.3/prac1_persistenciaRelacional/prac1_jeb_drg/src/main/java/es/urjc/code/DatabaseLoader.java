package es.urjc.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public void run(String... args) {


        // Lita de vuelos vacía;
        List<Vuelo> sinVuelos = new ArrayList<>();

        //Lista de revisiones vacía
        List<Revision> sinRevisiones = new ArrayList<>();

        //Lista de tripulantes vacía
        List<Tripulante> sinTripulantes = new ArrayList<>();

        //Lista de aviones vacía
        List<Avion> sinAviones = new ArrayList<>();

        Tripulante trip1 = new Tripulante("COM001","Alberto","Lopez Frau","Comanadante","IBERIA", new ArrayList <Vuelo> ());
        Tripulante trip2 = new Tripulante("COM002","Alvaro","Fernandez Lopez","Co-Piloto","IBERIA", sinVuelos);
        Tripulante trip3 = new Tripulante("COM003","Antonio","Gonzalez Ruiz","Sobrecargo","IBERIA", sinVuelos);


        Avion avion1 = avionRepository.save(new Avion("BOI001", "Boing", "Boing 737", 2500, sinVuelos, sinRevisiones));
        Avion avion2 = avionRepository.save(new Avion("BOI002", "Boing", "Boing 777", 1500, sinVuelos, sinRevisiones));
        Avion avion3 = avionRepository.save(new Avion("BOI003", "Boing", "Boing 767", 5500, sinVuelos, sinRevisiones));
        Avion avion4 = avionRepository.save(new Avion("AIR001", "Airbus", "A340", 2500, sinVuelos, sinRevisiones));
        Avion avion5 = avionRepository.save(new Avion("AVI002", "Airbus", "A380", 4500, sinVuelos, sinRevisiones));
        Avion avion6 = avionRepository.save(new Avion("AVI003", "Airbus", "A400", 6500, sinVuelos, sinRevisiones));

        Mecanico meca1 = mecanicoRepository.save(new Mecanico("MEC001","Roberto","Ruiz Garcia","Airbus",1995,"", sinRevisiones));
        Mecanico meca2 = mecanicoRepository.save(new Mecanico("MEC002","Rebeca","Tola Cruz","Airbus",1992,"", sinRevisiones));
        Mecanico meca3 = mecanicoRepository.save(new Mecanico("MEC003","Ruben","Muñoz Rodriguez","Airbus",1998,"", sinRevisiones));
        Mecanico meca4 = mecanicoRepository.save(new Mecanico("MEC004","Ramon","Lopez Perez","Airbus",2005,"", sinRevisiones));

        Aeropuerto aero1 = aeropuertoRepository.save(new Aeropuerto("MAD01","Barajas","Madrid","España",sinVuelos, sinRevisiones));
        Aeropuerto aero2 = aeropuertoRepository.save(new Aeropuerto("MAD02","Cuatro Vientos","Madrid","España",sinVuelos, sinRevisiones));
        Aeropuerto aero3 = aeropuertoRepository.save(new Aeropuerto("BAR01","El prat","Barcelona","España",sinVuelos, sinRevisiones));



        // Me creo una tripulación (para los vuelos) --> NO FUNCIONA
        List<Tripulante> tripulantes = new ArrayList<>();
        tripulantes.add(trip1);
        tripulantes.add(trip2);
        tripulantes.add(trip3);

        Vuelo vuelo1 = new Vuelo("IBE001","Iberia",new Date(System.currentTimeMillis()-10000000),tripulantes, avion1, aero1, aero3);
        vueloRepository.save(vuelo1);




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


    /*
        // Recupera productos
        List<Producto> productos = repository.findAll();
        System.out.println("Productos con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(productos);
*/
    }

/*
    private static void muestraDatos(List<Producto> datos) {
        for (Producto p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }
*/
}

package es.urjc.code;

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

        // Guardando datos
        // tripulantes
        /*
        tripulanteRepository.save(new Tripulante("COM001","Alberto","Lopez Frau","Comanadante",new Vuelo("")));
        tripulanteRepository.save(new Tripulante("COM002","Alvaro","Fernandez Lopez","Co-Piloto",new Vuelo("")));
        tripulanteRepository.save(new Tripulante("COM003","Antonio","Gonzalez Ruiz","Sobrecargo",new Vuelo("")));

        aeropuertoRepository.save(new Aeropuerto("MAD01","Barajas","Madrid","España",new Vuelo(), new Revision()));
        aeropuertoRepository.save(new Aeropuerto("MAD02","Cuatro Vientos","Madrid","España",new Vuelo(), new Revision()));
        aeropuertoRepository.save(new Aeropuerto("BAR01","El prat","Barcelona","España",new Vuelo(), new Revision()));

        vueloRepository.save(new Vuelo("IBE001","Iberia",new Date(System.currentTimeMillis()-10000000),new List<Tripulante>(),new Avion(), new Aeropuerto(), new Aeropuerto()));
        vueloRepository.save(new Vuelo("IBE002","Iberia",new Date(System.currentTimeMillis()-20000000),new List<Tripulante>(),new Avion(), new Aeropuerto(), new Aeropuerto()));
        vueloRepository.save(new Vuelo("RYN001","RyanAir",new Date(System.currentTimeMillis()-30000000),new List<Tripulante>(),new Avion(), new Aeropuerto(), new Aeropuerto()));
        vueloRepository.save(new Vuelo("VUE001","Vueling",new Date(System.currentTimeMillis()-40000000),new List<Tripulante>(),new Avion(), new Aeropuerto(), new Aeropuerto()));
        vueloRepository.save(new Vuelo("VUE002","Vueling",new Date(System.currentTimeMillis()-50000000),new List<Tripulante>(),new Avion(), new Aeropuerto(), new Aeropuerto()));

        mecanicoRepository.save(new Mecanico("MEC001","Roberto","Ruiz Garcia","Airbus",1995,"", new List<Revision>()));
        mecanicoRepository.save(new Mecanico("MEC002","Rebeca","Tola Cruz","Airbus",1992,"", new List<Revision>()));
        mecanicoRepository.save(new Mecanico("MEC003","Ruben","Muñoz Rodriguez","Airbus",1998,"", new List<Revision>()));
        mecanicoRepository.save(new Mecanico("MEC004","Ramon","Lopez Perez","Airbus",2005,"", new List<Revision>()));

        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-150000000),new Date(System.currentTimeMillis()-10000), 15, "periodica","cambio de aceite y revisión del motor"), new Avion(), new Mecanico(), new Aeropuerto());
        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-250000000),new Date(System.currentTimeMillis()-20000), 20, "periodica","revisión del motor e interiores"), new Avion(), new Mecanico(), new Aeropuerto());
        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-350000000),new Date(System.currentTimeMillis()-30000), 25, "periodica","interiores y cabina"), new Avion(), new Mecanico(), new Aeropuerto());
        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-450000000),new Date(System.currentTimeMillis()-40000), 30, "reparacion","cabina y asientos"), new Avion(), new Mecanico(), new Aeropuerto());
        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-550000000),new Date(System.currentTimeMillis()-50000), 35, "reparacion","reparacion exteriores"), new Avion(), new Mecanico(), new Aeropuerto());
        revisionRepository.save(new Revision(new Date(System.currentTimeMillis()-650000000),new Date(System.currentTimeMillis()-60000), 40, "reparacion","sustitucion caja negra"), new Avion(), new Mecanico(), new Aeropuerto());

        avionRepository.save(new Avion("BOI001", "Boing", "Boing 737", 2500, new List<Vuelo>(), new List<Revision>()));
        avionRepository.save(new Avion("BOI002", "Boing", "Boing 777", 1500, new List<Vuelo>(), new List<Revision>()));
        avionRepository.save(new Avion("BOI003", "Boing", "Boing 767", 5500, new List<Vuelo>(), new List<Revision>()));
        avionRepository.save(new Avion("AIR001", "Airbus", "A340", 2500, new List<Vuelo>(), new List<Revision>()));
        avionRepository.save(new Avion("AVI002", "Airbus", "A380", 4500, new List<Vuelo>(), new List<Revision>()));
        avionRepository.save(new Avion("AVI003", "Airbus", "A400", 6500, new List<Vuelo>(), new List<Revision>()));

*/
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

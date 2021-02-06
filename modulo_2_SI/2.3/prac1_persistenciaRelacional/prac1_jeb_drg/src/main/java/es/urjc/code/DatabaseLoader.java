package es.urjc.code;

import java.util.Date;
import java.util.List;

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
        repository.save(new Producto("Apple Macbook", new Version("1.0",new Date(System.currentTimeMillis()-50000000))));
        repository.save(new Producto("Apple Macbook Pro", new Version("1.5",new Date(System.currentTimeMillis()))));

        // Recupera productos
        List<Producto> productos = repository.findAll();
        System.out.println("Productos con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(productos);

    }


    private static void muestraDatos(List<Producto> datos) {
        for (Producto p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

}

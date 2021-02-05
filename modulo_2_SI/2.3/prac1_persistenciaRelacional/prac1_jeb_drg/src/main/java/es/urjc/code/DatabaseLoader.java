package es.urjc.code;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository repository;

    @Override
    public void run(String... args) {

        // Guardando algunos productos
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

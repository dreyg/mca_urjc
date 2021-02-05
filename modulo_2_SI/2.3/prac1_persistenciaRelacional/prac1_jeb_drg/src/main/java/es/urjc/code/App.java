package es.urjc.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Juan Escribano & David Rey
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        // TODO cambiar propiedad a "update"
        SpringApplication.run(App.class, args);
    }
}

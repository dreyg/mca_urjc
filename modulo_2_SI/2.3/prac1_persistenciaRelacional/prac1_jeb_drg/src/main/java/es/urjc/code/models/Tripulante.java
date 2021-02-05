package es.urjc.code.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codTripulante;
    private String nombre;
    private String apellido;
    private String puesto;
    private String compania;

    @ManyToMany
    private List<Vuelo> vuelos;

}

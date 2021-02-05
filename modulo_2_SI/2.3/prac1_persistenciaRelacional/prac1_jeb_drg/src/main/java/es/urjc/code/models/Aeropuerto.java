package es.urjc.code.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codAeropuerto;
    private String nombre;
    private String ciudad;
    private Integer pais;

    // vuelo
    @OneToMany(cascade=CascadeType.ALL, mappedBy="vuelo")
    private List<Vuelo> vuelos;

    //revisión
    @OneToMany(cascade=CascadeType.ALL, mappedBy="revision")
    private List<Revision> revisiones;


}

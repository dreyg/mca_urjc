package es.urjc.code.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codAvion;
    private String fabricante;
    private String modelo;
    private Integer horasVuelo;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="vuelo")
    private List<Vuelo> vuelos;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="revision")
    private List<Revision> revisiones;


}

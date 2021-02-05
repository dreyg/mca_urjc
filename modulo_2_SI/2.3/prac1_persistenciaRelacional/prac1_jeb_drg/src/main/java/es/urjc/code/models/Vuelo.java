package es.urjc.code.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codVuelo;
    private String compania;
    private String codAvion;
    private Date fechaHoraSalida;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="tripulante")
    private List<Tripulante> tripulantes;
    @ManyToOne
    private Avion avion;
    @ManyToOne
    private Aeropuerto aeropuertoOrigen;
    @ManyToOne
    private Aeropuerto aeropuertoDestino;


}

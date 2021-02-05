package es.urjc.code.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date fechaInicio;
    private Date fechaFin;
    private Integer numHorasEmpleadas;
    private String tipoRevision;
    private String descripcionTrabajo;

    @ManyToOne
    private Avion avion;

    @ManyToOne
    private Mecanico mecanico;

    @ManyToOne
    private Aeropuerto aeropuerto;

}

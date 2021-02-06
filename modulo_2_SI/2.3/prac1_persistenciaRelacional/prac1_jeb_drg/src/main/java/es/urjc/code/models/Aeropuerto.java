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

    public Aeropuerto() {
    }

    public Aeropuerto(String codAeropuerto, String nombre, String ciudad, Integer pais, List<Vuelo> vuelos, List<Revision> revisiones) {
        this.codAeropuerto = codAeropuerto;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.vuelos = vuelos;
        this.revisiones = revisiones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodAeropuerto() {
        return codAeropuerto;
    }

    public void setCodAeropuerto(String codAeropuerto) {
        this.codAeropuerto = codAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getPais() {
        return pais;
    }

    public void setPais(Integer pais) {
        this.pais = pais;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id=" + id +
                ", codAeropuerto='" + codAeropuerto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais=" + pais +
                ", vuelos=" + vuelos +
                ", revisiones=" + revisiones +
                '}';
    }
}

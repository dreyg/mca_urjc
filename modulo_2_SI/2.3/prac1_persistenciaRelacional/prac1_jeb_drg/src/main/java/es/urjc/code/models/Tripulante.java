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

    public Tripulante() {
    }

    public Tripulante(String codTripulante, String nombre, String apellido, String puesto, String compania, List<Vuelo> vuelos) {
        this.codTripulante = codTripulante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.compania = compania;
        this.vuelos = vuelos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodTripulante() {
        return codTripulante;
    }

    public void setCodTripulante(String codTripulante) {
        this.codTripulante = codTripulante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "id=" + id +
                ", codTripulante='" + codTripulante + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + puesto + '\'' +
                ", compania='" + compania + '\'' +
                ", vuelos=" + vuelos +
                '}';
    }
}

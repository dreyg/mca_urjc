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

    public Vuelo() {
    }

    public Vuelo(long id, String codVuelo, String compania, String codAvion, Date fechaHoraSalida, List<Tripulante> tripulantes, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino) {
        this.id = id;
        this.codVuelo = codVuelo;
        this.compania = compania;
        this.codAvion = codAvion;
        this.fechaHoraSalida = fechaHoraSalida;
        this.tripulantes = tripulantes;
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", codVuelo='" + codVuelo + '\'' +
                ", compania='" + compania + '\'' +
                ", codAvion='" + codAvion + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", tripulantes=" + tripulantes +
                ", avion=" + avion +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", aeropuertoDestino=" + aeropuertoDestino +
                '}';
    }
}

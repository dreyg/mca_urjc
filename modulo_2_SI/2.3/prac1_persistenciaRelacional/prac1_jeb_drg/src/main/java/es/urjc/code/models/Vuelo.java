package es.urjc.code.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codVuelo;
    private String compania;
    private Date fechaHoraSalida;
    private Float duracionVuelo;

    @OneToMany(mappedBy = "vue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VueloTripulante> tripulantes  = new ArrayList<>();
    @ManyToOne
    private Avion avion;
    @ManyToOne
    private Aeropuerto aeropuertoOrigen;
    @ManyToOne
    private Aeropuerto aeropuertoDestino;

    public Vuelo() {
    }

    public Vuelo(String codVuelo, String compania, Date fechaHoraSalida, Float duracionVuelo, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino) {
        this.codVuelo = codVuelo;
        this.compania = compania;
        this.fechaHoraSalida = fechaHoraSalida;
        this.duracionVuelo = duracionVuelo;
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

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public List<VueloTripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<VueloTripulante> tripulantes) {
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

    public Float getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(Float duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", codVuelo='" + codVuelo + '\'' +
                ", compania='" + compania + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", duracionVuelo=" + duracionVuelo +
                ", tripulantes=" + tripulantes +
                ", avion=" + avion +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", aeropuertoDestino=" + aeropuertoDestino +
                '}';
    }
}

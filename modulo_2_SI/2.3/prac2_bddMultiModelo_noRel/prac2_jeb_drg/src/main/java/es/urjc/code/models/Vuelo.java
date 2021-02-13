package es.urjc.code.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
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
    private Date fechaHoraLlegada;
    private Float duracionVuelo;

    @OneToMany(mappedBy = "vue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VueloTripulante> tripulantes  = new ArrayList<>();
    @ManyToOne
    private Avion avion;
    @ManyToOne
    private Aeropuerto aeropuertoOrigen;
    @ManyToOne
    private Aeropuerto aeropuertoDestino;

    private String tripulantesjson;

    public Vuelo() {
    }

    public Vuelo(long id, String codVuelo, String compania, Date fechaHoraSalida, Date fechaHoraLlegada, Float duracionVuelo, List<VueloTripulante> tripulantes, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String tripulantesjson) {
        this.id = id;
        this.codVuelo = codVuelo;
        this.compania = compania;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.duracionVuelo = duracionVuelo;
        this.tripulantes = tripulantes;
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.tripulantesjson = tripulantesjson;
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

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Float getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(Float duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
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

    public String getTripulantesjson() {
        return tripulantesjson;
    }

    public void setTripulantesjson(String tripulantesjson) {
        this.tripulantesjson = tripulantesjson;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", codVuelo='" + codVuelo + '\'' +
                ", compania='" + compania + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", fechaHoraLlegada=" + fechaHoraLlegada +
                ", duracionVuelo=" + duracionVuelo +
                ", tripulantes=" + tripulantes +
                ", avion=" + avion +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", aeropuertoDestino=" + aeropuertoDestino +
                ", tripulantesjson='" + tripulantesjson + '\'' +
                '}';
    }
}

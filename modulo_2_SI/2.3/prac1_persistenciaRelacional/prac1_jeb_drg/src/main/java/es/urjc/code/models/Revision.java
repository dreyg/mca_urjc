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

    public Revision() {
    }

    public Revision(long id, Date fechaInicio, Date fechaFin, Integer numHorasEmpleadas, String tipoRevision, String descripcionTrabajo, Avion avion, Mecanico mecanico, Aeropuerto aeropuerto) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numHorasEmpleadas = numHorasEmpleadas;
        this.tipoRevision = tipoRevision;
        this.descripcionTrabajo = descripcionTrabajo;
        this.avion = avion;
        this.mecanico = mecanico;
        this.aeropuerto = aeropuerto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getNumHorasEmpleadas() {
        return numHorasEmpleadas;
    }

    public void setNumHorasEmpleadas(Integer numHorasEmpleadas) {
        this.numHorasEmpleadas = numHorasEmpleadas;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", numHorasEmpleadas=" + numHorasEmpleadas +
                ", tipoRevision='" + tipoRevision + '\'' +
                ", descripcionTrabajo='" + descripcionTrabajo + '\'' +
                ", avion=" + avion +
                ", mecanico=" + mecanico +
                ", aeropuerto=" + aeropuerto +
                '}';
    }
}

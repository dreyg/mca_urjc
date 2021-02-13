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

    @OneToMany(cascade=CascadeType.ALL, mappedBy="avion")
    private List<Vuelo> vuelos;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="avion")
    private List<Revision> revisiones;

    private String revisionjson;

    public Avion() {
    }

    public Avion(long id, String codAvion, String fabricante, String modelo, Integer horasVuelo, List<Vuelo> vuelos, List<Revision> revisiones, String revisionjson) {
        this.id = id;
        this.codAvion = codAvion;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horasVuelo = horasVuelo;
        this.vuelos = vuelos;
        this.revisiones = revisiones;
        this.revisionjson = revisionjson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(Integer horasVuelo) {
        this.horasVuelo = horasVuelo;
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

    public String getRevisionjson() {
        return revisionjson;
    }

    public void setRevisionjson(String revisionjson) {
        this.revisionjson = revisionjson;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", codAvion='" + codAvion + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", horasVuelo=" + horasVuelo +
                ", vuelos=" + vuelos +
                ", revisiones=" + revisiones +
                ", revisionjson='" + revisionjson + '\'' +
                '}';
    }
}

package es.urjc.code.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Provincia {

    @Id
    private String id;
    private String Nombre;
    private String CA;
    private Integer Superficie;
    private List<Datos> Datos;

    public Provincia() {
    }

    public Provincia(String id, String nombre, String CA, Integer superficie, List<es.urjc.code.models.Datos> datos) {
        this.id = id;
        Nombre = nombre;
        this.CA = CA;
        Superficie = superficie;
        Datos = datos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public Integer getSuperficie() {
        return Superficie;
    }

    public void setSuperficie(Integer superficie) {
        Superficie = superficie;
    }

    public List<es.urjc.code.models.Datos> getDatos() {
        return Datos;
    }

    public void setDatos(List<es.urjc.code.models.Datos> datos) {
        Datos = datos;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "id='" + id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", CA='" + CA + '\'' +
                ", Superficie=" + Superficie +
                ", Datos=" + Datos +
                '}';
    }
}

package es.urjc.code.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tripulante extends Empleado{

    private String puesto;

    //vuelo
    @OneToMany(mappedBy = "tri", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VueloTripulante> vuelos = new ArrayList<>();

    public Tripulante() {
    }

    public Tripulante(String codTripulante, String nombre, String apellido, String puesto, String compania) {
        super(codTripulante,nombre,apellido,compania);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<VueloTripulante> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<VueloTripulante> vuelos) {
        this.vuelos = vuelos;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        return padre + "Tripulante{" +
                "puesto='" + puesto + '\'' +
                ", vuelos=" + vuelos +
                '}';
    }
}

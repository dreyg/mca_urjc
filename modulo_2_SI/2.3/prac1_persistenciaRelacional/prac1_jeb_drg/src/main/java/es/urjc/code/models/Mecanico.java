package es.urjc.code.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mecanico extends Empleado{

    private Integer anioIncorporacion;
    private String formacionPrevia;

    @OneToMany(mappedBy = "mecanico")
    private List<Revision> revisiones;

    public Mecanico() {
    }

    public Mecanico(String codMecanico, String nombre, String apellidos, String empresa, Integer anioIncorporacion, String formacionPrevia, List<Revision> revisiones) {
        super(codMecanico,nombre, apellidos, empresa);
        this.anioIncorporacion = anioIncorporacion;
        this.formacionPrevia = formacionPrevia;
        this.revisiones = revisiones;
    }

    public Integer getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(Integer anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getFormacionPrevia() {
        return formacionPrevia;
    }

    public void setFormacionPrevia(String formacionPrevia) {
        this.formacionPrevia = formacionPrevia;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        return padre +"Mecanico{" +
                "anioIncorporacion=" + anioIncorporacion +
                ", formacionPrevia='" + formacionPrevia + '\'' +
                ", revisiones=" + revisiones +
                '}';
    }
}

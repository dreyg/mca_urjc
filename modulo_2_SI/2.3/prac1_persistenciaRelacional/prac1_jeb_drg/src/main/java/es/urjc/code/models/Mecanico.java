package es.urjc.code.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codMecanico;
    private String nombre;
    private String apellidos;
    private String empresa;
    private Integer anioIncorporacion;
    private String formacionPrevia;

    @OneToMany
    private List<Revision> revisiones;

    public Mecanico() {
    }

    public Mecanico(Long id, String codMecanico, String nombre, String apellidos, String empresa, Integer anioIncorporacion, String formacionPrevia, List<Revision> revisiones) {
        this.id = id;
        this.codMecanico = codMecanico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.anioIncorporacion = anioIncorporacion;
        this.formacionPrevia = formacionPrevia;
        this.revisiones = revisiones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodMecanico() {
        return codMecanico;
    }

    public void setCodMecanico(String codMecanico) {
        this.codMecanico = codMecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
        return "Mecanico{" +
                "id=" + id +
                ", codMecanico='" + codMecanico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", empresa='" + empresa + '\'' +
                ", anioIncorporacion=" + anioIncorporacion +
                ", formacionPrevia='" + formacionPrevia + '\'' +
                ", revisiones=" + revisiones +
                '}';
    }
}

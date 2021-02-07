package es.urjc.code.dto;

import java.util.Date;

public class TripulanteViajesDTO {


    private String codEmpleado;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private Date fechaHoraSalida;

    public TripulanteViajesDTO() {
    }

    public TripulanteViajesDTO(String codEmpleado, String nombre, String apellidos, String ciudad, Date fechaHoraSalida) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public String toString() {
        return "TripulanteViajesDTO{" +
                "codEmpleado='" + codEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                '}';
    }
}

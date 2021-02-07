package es.urjc.code.dto;

import java.util.Date;

public class VuelosAeropuertoDTO {


    private String codVuelo;
    private String ciudad;
    private String codAeropuerto;
    private Date horaSalida;
    private Float duracionVuelo;

    public VuelosAeropuertoDTO() {
    }

    public VuelosAeropuertoDTO(String codVuelo, String ciudad, String codAeropuerto, Date horaSalida, Float duracionVuelo) {
        this.codVuelo = codVuelo;
        this.ciudad = ciudad;
        this.codAeropuerto = codAeropuerto;
        this.horaSalida = horaSalida;
        this.duracionVuelo = duracionVuelo;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodAeropuerto() {
        return codAeropuerto;
    }

    public void setCodAeropuerto(String codAeropuerto) {
        this.codAeropuerto = codAeropuerto;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Float getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(Float duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
    }

    @Override
    public String toString() {
        return "VuelosAeropuertoDTO{" +
                "codVuelo='" + codVuelo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codAeropuerto='" + codAeropuerto + '\'' +
                ", horaSalida=" + horaSalida +
                ", duracionVuelo=" + duracionVuelo +
                '}';
    }
}

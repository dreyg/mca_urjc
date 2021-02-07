package es.urjc.code.dto;

public class TripulanteEstadisticasDTO {

    private String nombre;
    private String apellidos;
    private Long numVuelos;
    private Double duracionVuelos;

    public TripulanteEstadisticasDTO() {
    }

    public TripulanteEstadisticasDTO(String nombre, String apellidos, Long numVuelos, Double duracionVuelos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numVuelos = numVuelos;
        this.duracionVuelos = duracionVuelos;
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

    public Long getNumVuelos() {
        return numVuelos;
    }

    public void setNumVuelos(Long numVuelos) {
        this.numVuelos = numVuelos;
    }

    public Double getDuracionVuelos() {
        return duracionVuelos;
    }

    public void setDuracionVuelos(Double duracionVuelos) {
        this.duracionVuelos = duracionVuelos;
    }

    @Override
    public String toString() {
        return "TripulanteEstadisticasDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numVuelos=" + numVuelos +
                ", duracionVuelos=" + duracionVuelos +
                '}';
    }
}

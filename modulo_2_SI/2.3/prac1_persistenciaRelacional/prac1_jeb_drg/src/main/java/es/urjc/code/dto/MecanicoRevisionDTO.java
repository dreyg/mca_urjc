package es.urjc.code.dto;

public class MecanicoRevisionDTO {


    private String codAvion;
    private String nombre;
    private String apellidos;

    public MecanicoRevisionDTO() {
    }

    public MecanicoRevisionDTO(String codAvion, String nombre, String apellidos) {
        this.codAvion = codAvion;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
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

    @Override
    public String toString() {
        return "MecanicoRevisionDTO{" +
                "codAvion='" + codAvion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}

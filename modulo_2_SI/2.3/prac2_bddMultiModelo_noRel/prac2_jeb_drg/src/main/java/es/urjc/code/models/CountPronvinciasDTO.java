package es.urjc.code.models;

public class CountPronvinciasDTO {

    private String comunidadAutonoma;
    //private Integer numProvincias;


    public CountPronvinciasDTO() {
    }

    public CountPronvinciasDTO(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public String getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    @Override
    public String toString() {
        return "CountPronvinciasDTO{" +
                "comunidadAutonoma='" + comunidadAutonoma + '\'' +
                '}';
    }
}

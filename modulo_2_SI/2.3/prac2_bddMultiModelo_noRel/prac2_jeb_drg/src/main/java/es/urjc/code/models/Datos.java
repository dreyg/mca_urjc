package es.urjc.code.models;

public class Datos {

    private Integer Anyo;
    private Integer Valor;

    public Datos() {
    }

    public Datos(Integer anyo, Integer valor) {
        Anyo = anyo;
        Valor = valor;
    }

    public Integer getAnyo() {
        return Anyo;
    }

    public void setAnyo(Integer anyo) {
        Anyo = anyo;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer valor) {
        Valor = valor;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "Anyo=" + Anyo +
                ", Valor=" + Valor +
                '}';
    }
}

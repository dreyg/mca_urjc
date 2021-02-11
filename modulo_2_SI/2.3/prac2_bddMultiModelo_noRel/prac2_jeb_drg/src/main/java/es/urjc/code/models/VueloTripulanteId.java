package es.urjc.code.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class VueloTripulanteId implements Serializable {

    private Long vueId;
    private Long triId;

    public VueloTripulanteId() {
    }

    public VueloTripulanteId(Long vueId, Long triId) {
        this.vueId = vueId;
        this.triId = triId;
    }

    public Long getVueId() {
        return vueId;
    }

    public void setVueId(Long vueId) {
        this.vueId = vueId;
    }

    public Long getTriId() {
        return triId;
    }

    public void setTriId(Long triId) {
        this.triId = triId;
    }
}

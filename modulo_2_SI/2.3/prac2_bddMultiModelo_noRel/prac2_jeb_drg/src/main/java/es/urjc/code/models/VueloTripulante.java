package es.urjc.code.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class VueloTripulante {

    @EmbeddedId
    private VueloTripulanteId id;

    @ManyToOne
    @MapsId("vueId")
    private Vuelo vue;

    @ManyToOne
    @MapsId("triId")
    private Tripulante tri;

    public VueloTripulante() {
    }

    public VueloTripulante(Vuelo vue, Tripulante tri) {
        this.vue = vue;
        this.tri = tri;

        this.id = new VueloTripulanteId(vue.getId(), tri.getId());
    }

    public VueloTripulanteId getId() {
        return id;
    }

    public void setId(VueloTripulanteId id) {
        this.id = id;
    }

    public Vuelo getVue() {
        return vue;
    }

    public void setVue(Vuelo vue) {
        this.vue = vue;
    }

    public Tripulante getTri() {
        return tri;
    }

    public void setTri(Tripulante tri) {
        this.tri = tri;
    }
}

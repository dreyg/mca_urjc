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

}

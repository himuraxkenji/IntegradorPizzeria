package ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity;

import javax.persistence.*;

@Entity()
@Table(name = "barrios")
public class BarrioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_barrio;

    private String nombre;

    public BarrioEntity() {
    }


    public Integer getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(Integer id_barrio) {
        this.id_barrio = id_barrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

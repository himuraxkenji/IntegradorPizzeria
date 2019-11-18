package ar.edu.undec.pizzeriaboundaries.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarrioDTO {

    @JsonProperty("idBarrio")
    private int idBarrio;

    @JsonProperty("nombre")
    private String nombre;

    public BarrioDTO(@JsonProperty("id") Integer id,
                     @JsonProperty("nombre") String nombre) {
        this.idBarrio = id;
        this.nombre = nombre;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

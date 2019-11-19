package ar.edu.undec.pizzeriaboundaries.Service.ModeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PizzaDTO {

    @JsonProperty("id")
    private Integer idPizza;


    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("precio")
    private float precio;

    @JsonProperty("tiempoPreparacion")
    private String tiempoPreparacion;


    public PizzaDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("precio") float precio, @JsonProperty("tiempoPreparacion") String tiempoPreparacion){

        this.idPizza = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Integer getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Integer idPizza) {
        this.idPizza = idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}

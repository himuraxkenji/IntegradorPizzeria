package modelo;

import excepciones.BarrioIncompletoException;

public class Barrio {

    private Integer idBarrio;
    private String nombre;


    private Barrio(Integer idBarrio, String nombre) {
        this.idBarrio = idBarrio;
        this.nombre = nombre;
    }

    public static Barrio factoryBarrio(Integer idBarrio, String nombre) throws BarrioIncompletoException {
        if(idBarrio == null || nombre==null || nombre==""){
            throw new BarrioIncompletoException();
        }else{
            return new Barrio(idBarrio, nombre);
        }
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

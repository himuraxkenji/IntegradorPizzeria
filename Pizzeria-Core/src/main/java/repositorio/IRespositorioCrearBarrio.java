package repositorio;

import modelo.Barrio;

public interface IRespositorioCrearBarrio {

    boolean guardar(Barrio elBarrio);

    Barrio buscarBarrioPorNombre(String nombreBarrio);


}
package repositorio;

import modelo.Pizza;

public interface IRepositorioCrearPizza {

    boolean guardar(Pizza nuevaPizza);

    Pizza buscarPizzaPorNombre(String nombrePizza);
}

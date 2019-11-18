package repositorio;

import modelo.Pizza;

public interface IRepositorioModificarPizza {

    Pizza findByNombrePizza(String nombrePizza);

    boolean actualizarPizza(Pizza pizza);


}

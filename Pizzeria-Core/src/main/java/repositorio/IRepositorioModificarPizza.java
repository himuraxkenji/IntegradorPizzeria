package repositorio;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface IRepositorioModificarPizza {

    Pizza findByNombrePizza(String nombrePizza);

    boolean actualizarPizza(Pizza pizza);


}

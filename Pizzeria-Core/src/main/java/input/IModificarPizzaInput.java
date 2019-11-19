package input;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public interface IModificarPizzaInput {

    boolean modificarPizza(Pizza pizza) throws PizzaIncompletaException;

}

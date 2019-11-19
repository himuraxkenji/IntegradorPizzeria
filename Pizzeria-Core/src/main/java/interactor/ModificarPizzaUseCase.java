package interactor;

import excepciones.PizzaExisteException;
import modelo.Pizza;
import repositorio.IRepositorioModificarPizza;

public class ModificarPizzaUseCase {

    private IRepositorioModificarPizza iRepositorioModificarPizza;

    public ModificarPizzaUseCase(IRepositorioModificarPizza iRepositorioModificarPizza){

        this.iRepositorioModificarPizza = iRepositorioModificarPizza;
    }

    public boolean modificarPizza(Pizza pizzaNueva) throws PizzaExisteException {

        Pizza pizzaAModificar = iRepositorioModificarPizza.findByNombrePizza(pizzaNueva.getNombre());

        if(pizzaAModificar == null){

            return this.iRepositorioModificarPizza.actualizarPizza(pizzaNueva);

        }else {
            if(pizzaAModificar.getIdPizza() != pizzaNueva.getIdPizza()){
                throw new PizzaExisteException();
            }else{
                if(pizzaAModificar.getNombre().equals(pizzaNueva.getNombre())){
                    return this.iRepositorioModificarPizza.actualizarPizza(pizzaNueva);
                }
            }

        }
        return false;
    }


}

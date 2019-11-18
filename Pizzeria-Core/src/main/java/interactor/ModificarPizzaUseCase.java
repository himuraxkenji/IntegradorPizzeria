package interactor;

import excepciones.PizzaExisteException;
import modelo.Pizza;
import repositorio.IRepositorioModificarPizza;

public class ModificarPizzaUseCase {

    private IRepositorioModificarPizza iRepositorioModificarPizza;

    public ModificarPizzaUseCase(IRepositorioModificarPizza iRepositorioModificarPizza){

        this.iRepositorioModificarPizza = iRepositorioModificarPizza;
    }

    public boolean modificarPizza(Pizza pizza) throws PizzaExisteException {

        Pizza nuevaPizza = iRepositorioModificarPizza.findByNombrePizza(pizza.getNombre());

        if(nuevaPizza == null){

            return this.iRepositorioModificarPizza.actualizarPizza(nuevaPizza);

        }else {
            if(nuevaPizza.getIdPizza() == pizza.getIdPizza()){
                return this.iRepositorioModificarPizza.actualizarPizza(nuevaPizza);
            }else{

                throw new PizzaExisteException();
            }

        }

    }


}

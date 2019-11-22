package interactor;

import excepciones.PizzaExisteException;
import excepciones.PizzaIncompletaException;
import input.ICrearPizzaInput;
import modelo.Pizza;
import repositorio.IRepositorioCrearPizza;

public class CrearPizzaUseCase implements ICrearPizzaInput {

    private IRepositorioCrearPizza crearPizzaGateWay;

    public CrearPizzaUseCase(IRepositorioCrearPizza crearPizzaGateWay) {

        this.crearPizzaGateWay = crearPizzaGateWay;
    }

    @Override
    public boolean crearPizza(Pizza laPizza) throws PizzaExisteException, PizzaIncompletaException {
        if(crearPizzaGateWay.buscarPizzaPorNombre(laPizza.getNombre()) == null)
            return this.crearPizzaGateWay.guardar(laPizza);

        throw new PizzaExisteException();
    }
}

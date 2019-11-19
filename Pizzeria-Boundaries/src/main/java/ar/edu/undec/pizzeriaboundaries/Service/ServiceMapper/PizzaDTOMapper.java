package ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper;

import excepciones.PizzaIncompletaException;
import modelo.Pizza;

public class PizzaDTOMapper {

    public Pizza mapeoDTOCore(PizzaDTO pizzaDTO){
        try {

            return Pizza.factoryPizza(barrioDTO.getIdPizza(), barrioDTO.getNombre(), barrioDTO.getPrecio(), barrioDTO.getTiempoPrepareacion());
        }catch (PizzaIncompletaException ex){
            ex.printStackTrace();
            return null;
        }

    }


}

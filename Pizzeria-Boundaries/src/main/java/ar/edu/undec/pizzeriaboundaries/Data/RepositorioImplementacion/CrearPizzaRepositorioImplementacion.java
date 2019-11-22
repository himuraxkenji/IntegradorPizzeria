package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PizzaEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PizzaEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.ICrearPizzaCRUD;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioCrearPizza;

@Service
public class CrearPizzaRepositorioImplementacion implements IRepositorioCrearPizza {

    @Autowired
    private ICrearPizzaCRUD crearPizzaCRUD;

    @Override
    public boolean guardar(Pizza nuevaPizza) {
        PizzaEntity pizzaEntity = new PizzaEntityMapper().mapeoCoreData(nuevaPizza);
        boolean respuesta = crearPizzaCRUD.save(pizzaEntity) != null;
        return respuesta;
    }

    @Override
    public Pizza buscarPizzaPorNombre(String nombrePizza) throws PizzaIncompletaException {


        return null;
    }
}

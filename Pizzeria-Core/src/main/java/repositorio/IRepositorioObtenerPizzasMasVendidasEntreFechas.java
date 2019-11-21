package repositorio;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pizza;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface IRepositorioObtenerPizzasMasVendidasEntreFechas {

    HashMap<Pizza, Integer> obtenerPizzasMasVendidasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException;
}

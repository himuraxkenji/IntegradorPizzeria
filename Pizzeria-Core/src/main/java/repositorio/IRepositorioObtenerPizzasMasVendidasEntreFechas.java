package repositorio;


import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;

import java.time.LocalDateTime;

import java.util.List;


public interface IRepositorioObtenerPizzasMasVendidasEntreFechas {

    List<String> obtenerPizzasMasVendidasEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException;


}

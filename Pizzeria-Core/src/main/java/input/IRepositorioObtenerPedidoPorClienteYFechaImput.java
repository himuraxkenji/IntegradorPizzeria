package input;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Cliente;
import modelo.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioObtenerPedidoPorClienteYFechaImput {
    List<Pedido> obtenerPedidoPorClienteYfecha(Cliente cliente, LocalDateTime fecha) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException;
}

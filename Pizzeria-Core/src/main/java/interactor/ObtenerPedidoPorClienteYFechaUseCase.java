package interactor;

import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import input.IRepositorioObtenerPedidoPorClienteYFechaImput;
import modelo.Cliente;
import modelo.Pedido;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObtenerPedidoPorClienteYFechaUseCase implements IRepositorioObtenerPedidoPorClienteYFechaImput {
    private  IRepositorioObtenerPedidoPorClienteYFecha repositorio;

    public ObtenerPedidoPorClienteYFechaUseCase(IRepositorioObtenerPedidoPorClienteYFecha repositorio) {
       this.repositorio = repositorio;
    }

    @Override
    public List<Pedido> obtenerPedidoPorClienteYfecha(Cliente cliente, LocalDateTime fecha) throws FechaIncorrectaException, PedidoIncompletoException, PizzaIncompletaException {
        if(fecha.isAfter(LocalDateTime.now()))
            throw new FechaIncorrectaException();
        else return repositorio.obtenerPedidoPorClienteYFecha(cliente,fecha);
    }
}

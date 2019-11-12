package interactor;

import excepciones.FechaIncorrectaException;
import modelo.Cliente;
import modelo.Pedido;
import repositorio.IRepositorioObtenerPedidoPorClienteYFecha;

import java.time.LocalDate;
import java.util.ArrayList;

public class ObtenerPedidoPorClienteYFecha {
    private  IRepositorioObtenerPedidoPorClienteYFecha repositorio;

    public ObtenerPedidoPorClienteYFecha(IRepositorioObtenerPedidoPorClienteYFecha repositorio) {
       this.repositorio = repositorio;
    }

    public ArrayList<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDate fecha) throws FechaIncorrectaException {
        if(fecha.isAfter(LocalDate.now()))
            throw new FechaIncorrectaException();
        else return repositorio.obtenerPedidoPorClienteYFecha(cliente,fecha);
    }
}

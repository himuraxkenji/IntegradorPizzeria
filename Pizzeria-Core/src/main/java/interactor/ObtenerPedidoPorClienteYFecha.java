package interactor;

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

    public ArrayList<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDate fecha) {
        return repositorio.obtenerPedidoPorClienteYFecha(cliente,fecha);
    }
}

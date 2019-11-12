package repositorio;

import modelo.Cliente;
import modelo.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRepositorioObtenerPedidoPorClienteYFecha {
    public ArrayList<Pedido> obtenerPedidoPorClienteYFecha(Cliente cliente, LocalDate fecha);
}

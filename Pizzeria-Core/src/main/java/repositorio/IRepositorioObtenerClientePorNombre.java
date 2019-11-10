package repositorio;

import modelo.Cliente;

import java.util.List;

public interface IRepositorioObtenerClientePorNombre {

    List<Cliente> obtenerClientePorNombre(String nombreCliente);

}

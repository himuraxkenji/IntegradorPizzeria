package repositorio;

import modelo.Cliente;

import java.util.ArrayList;

public interface IRepositorioObtenerClientePorNombre {

    ArrayList<Cliente> obtenerClientePorNombre(String nombreCliente);

}

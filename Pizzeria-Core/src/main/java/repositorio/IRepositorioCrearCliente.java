package repositorio;

import modelo.Cliente;

public interface IRepositorioCrearCliente {

    boolean guardar(Cliente nuevoCliente);

    Cliente buscarClientePorNombre(String nombreCliente);

}

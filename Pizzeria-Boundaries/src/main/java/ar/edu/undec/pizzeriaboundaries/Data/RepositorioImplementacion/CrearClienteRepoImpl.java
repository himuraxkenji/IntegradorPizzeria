package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteRepoImpl implements IRepositorioCrearCliente {
    @Override
    public boolean guardar(Cliente nuevoCliente) {
        return false;
    }

    @Override
    public Cliente buscarClientePorDocumento(String documentoCliente) {
        return null;
    }
}

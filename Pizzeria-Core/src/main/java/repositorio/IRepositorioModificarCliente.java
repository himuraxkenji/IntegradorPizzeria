package repositorio;

import modelo.Cliente;

public interface IRepositorioModificarCliente {

    Cliente findByDni(String dni);

    Boolean actualizar(Cliente cliente);
}

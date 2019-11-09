package interactor;

import excepciones.ClienteExisteException;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteUseCase {

    private IRepositorioCrearCliente crearClienteGateway;

    public CrearClienteUseCase(IRepositorioCrearCliente crearClienteGateway) {
       this.crearClienteGateway = crearClienteGateway;
    }

    public boolean existeCliente(Cliente elCliente){
        return crearClienteGateway.buscarClientePorDocumento(elCliente.getNombre()) != null;
    }

    public boolean CrearCliente(Cliente elCliente) throws ClienteExisteException {
        if(!existeCliente(elCliente)) {
            return this.crearClienteGateway.guardar(elCliente);
        }
            throw new ClienteExisteException();

    }

}

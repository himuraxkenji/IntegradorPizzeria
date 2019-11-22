package interactor;

import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteUseCase implements ICrearClienteInput {

    private IRepositorioCrearCliente crearClienteGateway;

    public CrearClienteUseCase(IRepositorioCrearCliente crearClienteGateway) {
       this.crearClienteGateway = crearClienteGateway;
    }
    

    public boolean crearCliente(Cliente elCliente) throws ClienteExisteException {
        if(crearClienteGateway.buscarClientePorDocumento(elCliente.getDocumento()) == null) {
            return this.crearClienteGateway.guardar(elCliente);
        }
        throw new ClienteExisteException();

    }

}

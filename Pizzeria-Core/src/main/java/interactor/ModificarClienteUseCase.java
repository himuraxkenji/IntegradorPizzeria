package interactor;

import excepciones.ClienteExisteException;
import modelo.Cliente;
import repositorio.IRepositorioModificarCliente;

public class ModificarClienteUseCase {

    private IRepositorioModificarCliente modificarClienteRepo;

    public ModificarClienteUseCase(IRepositorioModificarCliente modificarClienteRepo) {
        this.modificarClienteRepo = modificarClienteRepo;
    }

    public Boolean actualizarCliente(Cliente clienteDatosNuevos) throws ClienteExisteException {
        Cliente clienteAModificar  = modificarClienteRepo.findByDni(clienteDatosNuevos.getDocumento());
        if(clienteAModificar == null )
            return this.modificarClienteRepo.actualizar(clienteDatosNuevos);
        else if(clienteAModificar.getIdCliente() != clienteDatosNuevos.getIdCliente())
            throw new ClienteExisteException();
        else{
            if (clienteAModificar.getDocumento().equals(clienteDatosNuevos.getDocumento()))
                return this.modificarClienteRepo.actualizar(clienteDatosNuevos);
        }
        return false;
    }
}

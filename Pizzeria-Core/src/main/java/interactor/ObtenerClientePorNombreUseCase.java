package interactor;

import modelo.Cliente;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.List;

public class ObtenerClientePorNombreUseCase implements IRepositorioObtenerClientePorNombre{

    private IRepositorioObtenerClientePorNombre obtenerClientePorNombreGateway;

    public ObtenerClientePorNombreUseCase(IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre){

        this.obtenerClientePorNombreGateway = iRepositorioObtenerClientePorNombre;
    }

    @Override
    public List<Cliente> obtenerClientePorNombre(String nombreCliente) {

        List<Cliente> nuevaLista = obtenerClientePorNombreGateway.obtenerClientePorNombre(nombreCliente);

        return nuevaLista;
    }



}

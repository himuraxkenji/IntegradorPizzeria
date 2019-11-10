package interactor;

import modelo.Cliente;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.List;

public class ObtenerClientePorNombreUseCase {

    private IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    public ObtenerClientePorNombreUseCase(IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre){

        this.iRepositorioObtenerClientePorNombre = iRepositorioObtenerClientePorNombre;
    }


    public List<Cliente> obtenerClientePorNombre(String nombreCliente){

        return (List<Cliente>) iRepositorioObtenerClientePorNombre.obtenerClientePorNombre(nombreCliente);
    }



}

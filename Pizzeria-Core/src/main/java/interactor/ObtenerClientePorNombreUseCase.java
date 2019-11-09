package interactor;

import modelo.Cliente;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;

public class ObtenerClientePorNombreUseCase {

    private IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    public ObtenerClientePorNombreUseCase(IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre){

        this.iRepositorioObtenerClientePorNombre = iRepositorioObtenerClientePorNombre;
    }


    public ArrayList<Cliente> obtenerPilotoPorNombre(String nombreCliente){

        return (ArrayList<Cliente>) obtenerPilotoPorNombre(nombreCliente);
    }



}

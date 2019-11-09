package interactor;

import modelo.Cliente;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;

public class ObtenerClientePorNombreUseCase {

    public IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    public ObtenerClientePorNombreUseCase(IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre){

        this.iRepositorioObtenerClientePorNombre = iRepositorioObtenerClientePorNombre;
    }


    public ArrayList<Cliente> obtenerPilotoPorNombre(String nombreCliente){

        return obtenerPilotoPorNombre(nombreCliente);
    }



}

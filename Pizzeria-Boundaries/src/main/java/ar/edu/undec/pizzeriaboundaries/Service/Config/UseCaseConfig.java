package ar.edu.undec.pizzeriaboundaries.Service.Config;

import interactor.CrearBarrioUseCase;
import interactor.CrearClienteUseCase;
import interactor.ModificarClienteUseCase;
import interactor.ObtenerClientePorNombreUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IRepositorioCrearBarrio;
import repositorio.IRepositorioCrearCliente;
import repositorio.IRepositorioModificarCliente;
import repositorio.IRepositorioObtenerClientePorNombre;

@Configuration
public class UseCaseConfig {


    @Autowired
    private IRepositorioModificarCliente iRepositorioModificarCliente;

    @Autowired
    private IRepositorioCrearBarrio iRepositorioCrearBarrio;

    @Autowired
    private IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    @Autowired
    private IRepositorioCrearCliente iRepositorioCrearCliente;

    @Bean
    public ModificarClienteUseCase modificarClienteUseCase(){
        return new ModificarClienteUseCase(iRepositorioModificarCliente);
    }

    @Bean
    public ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase(){
        return new ObtenerClientePorNombreUseCase(iRepositorioObtenerClientePorNombre);
    }

    @Bean
    public CrearClienteUseCase crearClienteUseCase(){
        return new CrearClienteUseCase(iRepositorioCrearCliente);
    }

    @Bean
    public CrearBarrioUseCase crearBarrioUseCase(){ return new CrearBarrioUseCase(iRepositorioCrearBarrio);}
}

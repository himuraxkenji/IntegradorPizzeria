package ar.edu.undec.pizzeriaboundaries.Service.Config;

import interactor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.*;

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

    @Autowired
    private IObtenerBarrioPorNombre iObtenerBarrioPorNombre;

    @Bean
    public ModificarClienteUseCase modificarClienteUseCase(){ return new ModificarClienteUseCase(iRepositorioModificarCliente); }

    @Bean
    public ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase(){ return new ObtenerClientePorNombreUseCase(iRepositorioObtenerClientePorNombre); }

    @Bean
    public CrearClienteUseCase crearClienteUseCase(){
        return new CrearClienteUseCase(iRepositorioCrearCliente);
    }

    @Bean
    public CrearBarrioUseCase crearBarrioUseCase(){ return new CrearBarrioUseCase(iRepositorioCrearBarrio);}

    @Bean
    public ObtenerBarrioPorNombreUseCase obtenerBarrioPorNombreUseCase(){ return new ObtenerBarrioPorNombreUseCase(iObtenerBarrioPorNombre);}
}

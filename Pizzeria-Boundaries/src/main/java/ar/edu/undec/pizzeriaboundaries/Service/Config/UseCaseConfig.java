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

    @Autowired
    private IRepositorioModificarPizza iRepositorioModificarPizza;

    @Autowired
<<<<<<< HEAD
    private IRepositorioCrearPedido iRepositorioCrearPedido;

    @Bean
    public CrearPedidoUseCase crearPedidoUseCase(){ return new CrearPedidoUseCase(iRepositorioCrearPedido);}
=======
    private IRepositorioModificarBarrio iRepositorioModificarBarrio;

    @Autowired
    private IRepositorioObtenerPizzaPorNombre iRepositorioObtenerPizzaPorNombre;
>>>>>>> master

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

    @Bean
    public ModificarPizzaUseCase modificarPizzaUseCase(){
        return new ModificarPizzaUseCase(iRepositorioModificarPizza);
    }

    @Bean
    public ModificarBarrioUseCase modificarBarrioUseCase(){
        return new ModificarBarrioUseCase(iRepositorioModificarBarrio);
    }

    @Bean
    public ObtenerPizzaPorNombreUseCase obtenerPizzaPorNombreUseCase(){
        return new ObtenerPizzaPorNombreUseCase(iRepositorioObtenerPizzaPorNombre);
    }

}

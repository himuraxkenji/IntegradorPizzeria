package ar.edu.undec.pizzeriaboundaries.Service.Config;

import interactor.ModificarClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.IRepositorioModificarCliente;

@Configuration
public class UseCaseConfig {


    @Autowired
    private IRepositorioModificarCliente iRepositorioModificarCliente;

    @Bean
    public ModificarClienteUseCase modificarClienteUseCase(){
        return new ModificarClienteUseCase(iRepositorioModificarCliente);
    }
}

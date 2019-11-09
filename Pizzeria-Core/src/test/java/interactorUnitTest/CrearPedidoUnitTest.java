package interactorUnitTest;


import Mockito.MockitoExtension;
import excepciones.*;
import interactor.CrearPedidoUseCase;
import javafx.beans.binding.When;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearPedidoUnitTest {

    @Mock
    IRepositorioCrearPedido CrearPedidoGateway;

    private Pedido cargaPedido() throws BarrioIncompletoException, PizzaIncompletaException, ClienteIncompletoException, PedidoIncompletoExcpetion {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        ArrayList<Pizza> items = new ArrayList<Pizza>();
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00f,15);
        Pizza laSegundaPizza=Pizza.factoryPizza(2,"Comun",200.00f,10);
        items.add(laPizza);
        items.add(laSegundaPizza);
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        LocalDateTime fecha = LocalDateTime.now();
        Pedido elPedido=Pedido.factoryPedido(1,elCliente, fecha, items,  1 );
        return elPedido;
    }

    @Test
    public void CrearPedido_PedidoNoExiste_GuardadoCorrecto() throws PedidoExisteException, ClienteIncompletoException, PedidoIncompletoExcpetion, BarrioIncompletoException, PizzaIncompletaException {
        Pedido elPedido = cargaPedido();
        when(CrearPedidoGateway.guardar(elPedido)).thenReturn(true);
        CrearPedidoUseCase crearPedidoUseCase = new CrearPedidoUseCase(CrearPedidoGateway);
        boolean resultado = crearPedidoUseCase.crearPedido(elPedido);
        Assertions.assertTrue(resultado);

    }

    @Test
    public void CrearPedido_PedidoExiste_PedidoExisteException() throws BarrioIncompletoException, PizzaIncompletaException, ClienteIncompletoException, PedidoIncompletoExcpetion {
       LocalDateTime fecha = LocalDateTime.now();
       ArrayList<Pizza> items = null;
       Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
       Cliente elCliente=Cliente.factoryCliente(1,"Rodrigo Alarcon","San Francisco 285",elBarrio,"28131367");
       Pedido elPedidoBuscado=cargaPedido();
       when(CrearPedidoGateway.buscarPedidoPorNumero(1)).thenReturn(Pedido.factoryPedido(1,1));


    }


}

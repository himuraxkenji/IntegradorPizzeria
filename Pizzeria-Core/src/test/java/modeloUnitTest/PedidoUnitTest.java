package modeloUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoUnitTest {
    @Test
    void instanciarPedidoPedidoCompletoInstanciaCorrecta() {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio.getNombre(),"39400500");
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00,15);
        ArrayList<Pizza> items = null;
        LocalDateTime fecha = LocalDateTime.now();
        Pedido elPedido=Pedido.factoryPedido(1,elCliente, fecha, items,  1 );
        assertNotNull(elPedido);
    }

    @Test
    void instanciarPedidoPedidoSinNroDePedidoInstanciaIncorrecta() {}
}

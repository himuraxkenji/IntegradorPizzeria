package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.*;
import interactor.ObtenerPizzasMasVendidasEntreFechasUseCase;
import modelo.Barrio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioObtenerPedidos;
import repositorio.IRepositorioObtenerPizzasMasVendidasEntreFechas;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerPizzasMasVendidasEntreFechasUnitTest {

    @Mock
    IRepositorioObtenerPizzasMasVendidasEntreFechas obtenerPizzasMasVendidasEntreFechasGateWay;
    @Mock
    IRepositorioObtenerPedidos obtenerPedidosGateWay;

    @Test
    public void ObtenerPizzasMasVendidasEntreFechas_PizzasCorrectas_DevuelveListaCorrecta() throws BarrioIncompletoException, ClienteIncompletoException, PizzaIncompletaException, PedidoIncompletoException, FechaIncorrectaException, PedidosNoEncontradosException {
       Barrio barrio1 = Barrio.factoryBarrio(1, "Centro");
       Barrio barrio2 = Barrio.factoryBarrio(2, "Paiman");
       Cliente rodrigo = Cliente.factoryCliente(1, "Rodrigo", "San fran 123", barrio1, "28131367");
       Cliente juan = Cliente.factoryCliente(2, "Juan", "Mama 443", barrio2, "Brasil 123");

        Pizza pizza1 = Pizza.factoryPizza(1, "Comun", 200.00f, 10);
        Pizza pizza2 = Pizza.factoryPizza(2, "Napolitana", 250.00f, 15);
        Pizza pizza3 = Pizza.factoryPizza(3, "Especial", 270.00f, 15);
        Pizza pizza4 = Pizza.factoryPizza(4, "Argentina", 350.00f, 20);
        Pizza pizza5 = Pizza.factoryPizza(5, "Palmitos", 300.00f, 15);
        Pizza pizza6 = Pizza.factoryPizza(6, "DobleMuzza", 300.00f, 15);
        Pizza pizza7 = Pizza.factoryPizza(7, "Mexicana", 320.00f, 20);
        Pizza pizza8 = Pizza.factoryPizza(8, "CuatroQuesos", 350.00f, 15);
        Pizza pizza9 = Pizza.factoryPizza(9, "Caballo", 370.00f, 25);
        Pizza pizza10 = Pizza.factoryPizza(10, "Morron", 250.00f, 15);

        Collection<Pizza> items1 = new ArrayList<>();
        items1.add(pizza1);
        items1.add(pizza3);
        items1.add(pizza1);
        items1.add(pizza5);

        Collection<Pizza> items2 = new ArrayList<>();
        items2.add(pizza1);
        items2.add(pizza1);
        items2.add(pizza7);
        items2.add(pizza6);
        items2.add(pizza2);

        Collection<Pizza> items3 = new ArrayList<>();
        items3.add(pizza1);
        items3.add(pizza4);
        items3.add(pizza8);
        items3.add(pizza9);
        items3.add(pizza10);
        items3.add(pizza2);

        Collection<Pizza> items4 = new ArrayList<>();
        items4.add(pizza1);
        items4.add(pizza2);
        items4.add(pizza3);
        items4.add(pizza2);
        items4.add(pizza3);
        items4.add(pizza8);

        Collection<Pizza> items5 = new ArrayList<>();
        items5.add(pizza1);
        items5.add(pizza1);
        items5.add(pizza4);
        items5.add(pizza10);
        items5.add(pizza5);
        items5.add(pizza3);
        items5.add(pizza2);
        items5.add(pizza1);

        Collection<Pizza> items6 = new ArrayList<>();
        items6.add(pizza1);
        items6.add(pizza3);
        items6.add(pizza4);
        items6.add(pizza7);
        items6.add(pizza2);
        items6.add(pizza10);
        items6.add(pizza3);



        Pedido pedido1 = Pedido.factoryPedido(1, rodrigo, LocalDateTime.of(2019, 11,8,19,30),
               items1 ,1);

        Pedido pedido2 = Pedido.factoryPedido(2, juan, LocalDateTime.of(2019, 11,8,19,45),
               items2 ,2);

        Pedido pedido3 = Pedido.factoryPedido(3, rodrigo, LocalDateTime.of(2019, 11,9,20,05),
               items3 ,3);

        Pedido pedido4 = Pedido.factoryPedido(4, juan, LocalDateTime.of(2019, 11,9,20,25),
               items4 ,4);

        Pedido pedido5 = Pedido.factoryPedido(5, rodrigo, LocalDateTime.of(2019, 11,10,20,14),
               items5 ,5);

        Pedido pedido6 = Pedido.factoryPedido(6, juan, LocalDateTime.of(2019, 11,10,20,45),
                items6 ,6);

        ArrayList<Pedido> losPedidosCargados = new ArrayList<>();
        losPedidosCargados.add(pedido1);
        losPedidosCargados.add(pedido2);
        losPedidosCargados.add(pedido3);
        losPedidosCargados.add(pedido4);
        losPedidosCargados.add(pedido5);
        losPedidosCargados.add(pedido6);

        LocalDateTime fechaInicio = LocalDateTime.of(2019,11,9,20,15);

        LocalDateTime fechaFin = LocalDateTime.of(2019, 11, 10, 21, 14);

       ArrayList<String> lasPizzasMasVendidas = new ArrayList<>();

       lasPizzasMasVendidas.add("Napolitana 7");
       lasPizzasMasVendidas.add("Comun 7");
       lasPizzasMasVendidas.add("Especial 5");
       lasPizzasMasVendidas.add("DobleMuzza 4");
       lasPizzasMasVendidas.add("Palmitos 3");




        when(obtenerPedidosGateWay.obtenerPedidos()).thenReturn(losPedidosCargados);
        when(obtenerPizzasMasVendidasEntreFechasGateWay.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin)).thenReturn(lasPizzasMasVendidas);
        ObtenerPizzasMasVendidasEntreFechasUseCase obtenerPizzasMasVendidasEntreFechas = new ObtenerPizzasMasVendidasEntreFechasUseCase(obtenerPizzasMasVendidasEntreFechasGateWay, obtenerPedidosGateWay);
        Assertions.assertEquals(6, obtenerPedidosGateWay.obtenerPedidos().size());
        Assertions.assertEquals( "Napolitana 7", obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin).get(0));
        Assertions.assertEquals( "Comun 7", obtenerPizzasMasVendidasEntreFechas.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin).get(1));



    }


}

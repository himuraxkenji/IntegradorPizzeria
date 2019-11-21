/*package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PedidoDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.PizzaDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ServiceMapper.PedidoDTOMapper;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import input.IObtenerPedidosInput;
import input.IObtenerPizzasMasVendidasFechasInput;
import modelo.Pedido;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPizzasMasVendidasEntreFechaServiceIT {

    @Mock
    IObtenerPizzasMasVendidasFechasInput obtenerPizzasMasVendidasFechasInput;

    @Mock
    IObtenerPedidosInput obtenerPedidosInput;

    private List<PedidoDTO> losPedidos = new ArrayList<>();

    private List<Pedido> factoryListaPedido(List<PedidoDTO> pedidos) throws PedidoIncompletoException {
        List<Pedido> devuelve = new ArrayList<>();
        for (PedidoDTO pedido : pedidos) {
            devuelve.add(new PedidoDTOMapper().mapeoDTOCore(pedido));
        }
        return devuelve;
    }

    public List<Pedido> factoryPedido() throws PedidoIncompletoException, PizzaIncompletaException {
        List<Pedido> pedidos = obtenerPedidosInput.obtenerPedidos();
    }


    @Test
    public void ObtenerPizzasMasVendidasEntreFecha_DevuelveCorrecto() throws PedidoIncompletoException, PizzaIncompletaException {
        BarrioDTO elBarrio = new BarrioDTO(1,"San Francisco");
        ClienteDTO cliente = new ClienteDTO(1,"Rodrigo Alarcon","San Francisco 285","28131367",elBarrio);
        ClienteDTO cliente2 = new ClienteDTO(2,"Juan Perez","San Martin 212","28124112",elBarrio);
        PizzaDTO Espcial = new PizzaDTO(1,"Especial",250.0f,15);
        PizzaDTO Comun = new PizzaDTO(2,"Comun",200.0f,10);
        List<PizzaDTO> losItems = new ArrayList<>();
        losItems.add(Espcial);
        losItems.add(Comun);
        PedidoDTO pedido1 = new PedidoDTO(1,cliente, LocalDateTime.of(2019,11,11,21,15),losItems,1);
        PedidoDTO pedido2 = new PedidoDTO(2,cliente2, LocalDateTime.of(2019,11,12,22,15),losItems,2);
        losPedidos.add(pedido1);
        losPedidos.add(pedido2);
        when( obtenerPedidosInput.obtenerPedidos()).thenReturn(this.factoryListaPedido(losPedidos));
        when(obtenerPizzasMasVendidasFechasInput.obtenerPizzasMasVendidasEntreFechas()).thenReturn();
    }


}
*/

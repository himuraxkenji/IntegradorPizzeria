package interactor;

import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import repositorio.IRepositorioObtenerPedidos;

import java.util.Collection;

public class ObtenerPedidosUseCase {

    private IRepositorioObtenerPedidos obtenerPedidosGateWay;

    public ObtenerPedidosUseCase(IRepositorioObtenerPedidos obtenerPedidosGateWay) {
        this.obtenerPedidosGateWay = obtenerPedidosGateWay;
    }

    public Collection<Pedido> obtenerPedidos() throws PedidoIncompletoException, PizzaIncompletaException {
        return obtenerPedidosGateWay.obtenerPedidos();
    }
}

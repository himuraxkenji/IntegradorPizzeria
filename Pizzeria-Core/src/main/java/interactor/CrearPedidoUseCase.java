package interactor;

import excepciones.PedidoExisteException;
import modelo.Pedido;
import repositorio.IRepositorioCrearPedido;

public class CrearPedidoUseCase {

    private IRepositorioCrearPedido CrearPedidoGateWay;

    public CrearPedidoUseCase(IRepositorioCrearPedido crearPedidoGateWay) {
        this.CrearPedidoGateWay = crearPedidoGateWay;
    }

    public boolean existePedido(Pedido elPedido){
        return CrearPedidoGateWay.buscarPedidoPorNumero(elPedido.getNumeroPedido()) != null;
    }

    public boolean crearPedido(Pedido elPedido) throws PedidoExisteException {
        if(!existePedido(elPedido)){
            return this.CrearPedidoGateWay.guardar(elPedido);
        }
        throw new PedidoExisteException();
    }
}

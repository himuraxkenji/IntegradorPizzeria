package repositorio;

import modelo.Pedido;

public interface IRepositorioCrearPedido {

    boolean guardar(Pedido elPedido);

    Pedido buscarPedidoPorNumero(Integer numeroPedido);


}

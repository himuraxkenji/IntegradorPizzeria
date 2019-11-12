package repositorio;

import modelo.Pedido;

public interface IRepositorioModificarPedido {

    Pedido findByNroPedido(Integer numeroPedido);

    Boolean actualizar(Pedido Pedido);

}

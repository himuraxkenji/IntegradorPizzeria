package interactor;



import excepciones.PedidoExisteException;
import modelo.Pedido;
import repositorio.IRepositorioModificarPedido;

public class ModificarPedidoUseCase {
    private IRepositorioModificarPedido modificarPedidoRepo;

   
    //Constructor
    public ModificarPedidoUseCase(IRepositorioModificarPedido modificarPedidoRepo) {
        this.modificarPedidoRepo = modificarPedidoRepo;
    }


	public Boolean actualizarPedido(Pedido PedidoDatosNuevos) throws PedidoExisteException {
        Pedido PedidoAModificar  = modificarPedidoRepo.findByNroPedido(PedidoDatosNuevos.getNumeroPedido());
     
        if(PedidoAModificar == null )
            return this.modificarPedidoRepo.actualizar(PedidoDatosNuevos);
        else if(PedidoAModificar.getIdPedido() != PedidoDatosNuevos.getIdPedido())
            throw new PedidoExisteException();
        else{
            if (PedidoAModificar.getNumeroPedido().equals(PedidoDatosNuevos.getNumeroPedido()))
                return this.modificarPedidoRepo.actualizar(PedidoDatosNuevos);
        }
        return false;
    }




}

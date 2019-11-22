package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.PedidoEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.ICrearPedidoCRUD;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioCrearPedido;

@Service
public class CrearPedidoRepositorioImplementacion implements IRepositorioCrearPedido {

    @Autowired
    private ICrearPedidoCRUD crearPedidoCRUD;

    @Override
    public boolean guardar(Pedido elPedido) {
        PedidoEntity pedidoEntity = new PedidoEntityMapper().mapeoCoreData(elPedido);
        boolean respuesta = crearPedidoCRUD.save(pedidoEntity).getIdPedido() != null;
        return respuesta;
    }

    @Override
    public Pedido buscarPedidoPorNumero(Integer numeroPedido) throws PedidoIncompletoException, PizzaIncompletaException {
        PedidoEntity pedidoBuscado = this.crearPedidoCRUD.findByNumeroPedido(numeroPedido);
        if(pedidoBuscado != null)
            return new PedidoEntityMapper().mapeoDataCore(pedidoBuscado);
        return null;
    }
}

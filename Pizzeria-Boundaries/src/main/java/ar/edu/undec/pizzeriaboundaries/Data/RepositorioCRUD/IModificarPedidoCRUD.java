package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModificarPedidoCRUD extends CrudRepository<PedidoEntity, Integer> {
    PedidoEntity findByNroPedido(Integer numeroPedido);
}

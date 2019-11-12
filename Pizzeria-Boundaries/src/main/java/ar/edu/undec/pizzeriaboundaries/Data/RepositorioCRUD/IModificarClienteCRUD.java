package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModificarClienteCRUD extends CrudRepository<ClienteEntity, Integer> {

    ClienteEntity findByDocumento(String documento);
}

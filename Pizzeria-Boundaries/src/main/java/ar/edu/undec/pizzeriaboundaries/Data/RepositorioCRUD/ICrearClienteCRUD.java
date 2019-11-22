package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.ClienteEntity;
import modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearClienteCRUD extends CrudRepository<ClienteEntity, Integer> {

    ClienteEntity findByDocumento(String documento);

}

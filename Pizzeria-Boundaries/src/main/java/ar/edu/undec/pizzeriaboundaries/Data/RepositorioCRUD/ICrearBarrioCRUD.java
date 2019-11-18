package ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD;

import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrearBarrioCRUD extends CrudRepository<BarrioEntity, Integer> {
    BarrioEntity findByNombre(String nombre);
}

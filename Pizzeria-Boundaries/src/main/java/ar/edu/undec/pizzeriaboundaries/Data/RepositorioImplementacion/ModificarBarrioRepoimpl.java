package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarBarrioCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarBarrio;

public class ModificarBarrioRepoimpl {
    @Service
    public class ModificarBarrioRepoImpl implements IRepositorioModificarBarrio {

        @Autowired
        IModificarBarrioCRUD iModificarBarrioCRUD;

        @Override
        public Boolean actualizar(Barrio Barrio) {
            BarrioEntity BarrioEntity = new BarrioEntityMapper().mapeoCoreData(Barrio);
            return iModificarBarrioCRUD.save(BarrioEntity) != null;
        }


        @Override
        public Barrio findByNombre(String nombre) {
            return null;
        }
    }

}

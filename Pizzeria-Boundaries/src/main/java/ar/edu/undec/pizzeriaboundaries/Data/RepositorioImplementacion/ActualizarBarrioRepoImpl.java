package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.IModificarBarrioCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioModificarBarrio;

@Service
public class ActualizarBarrioRepoImpl implements IRepositorioModificarBarrio {


    @Autowired
    IModificarBarrioCRUD modificarBarrioCRUD;


    @Override
    public Barrio findByNombre(String nombre) {
        BarrioEntity barrioAModificar = modificarBarrioCRUD.findByNombre(nombre);
        if(barrioAModificar == null)
            return null;
        return new BarrioEntityMapper().mapeoDataCore(barrioAModificar);
    }

    @Override
    public Boolean actualizar(Barrio barrio) {
        BarrioEntity barrioEntity = new BarrioEntityMapper().mapeoCoreData(barrio);
        return modificarBarrioCRUD.save(barrioEntity) != null;
    }




}

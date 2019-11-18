package ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion;

import ar.edu.undec.pizzeriaboundaries.Data.EntityMapper.BarrioEntityMapper;
import ar.edu.undec.pizzeriaboundaries.Data.ModelosEntity.BarrioEntity;
import ar.edu.undec.pizzeriaboundaries.Data.RepositorioCRUD.ICrearBarrioCRUD;
import modelo.Barrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IRepositorioCrearBarrio;

@Service
public class CrearBarrioRepoImpl implements IRepositorioCrearBarrio {

    @Autowired
    ICrearBarrioCRUD iCrearBarrioCRUD;

    @Override
    public boolean guardar(Barrio barrio) {
        BarrioEntity barrioEntity = new BarrioEntityMapper().mapeoCoreData(barrio);
        return this.iCrearBarrioCRUD.save(barrioEntity) != null;
    }

    @Override
    public Barrio buscarBarrioPorNombre(String nombreBarrio) {
        Barrio barrio = new BarrioEntityMapper().mapeoDataCore(iCrearBarrioCRUD.findByNombre(nombreBarrio));
        if (barrio != null)
            return barrio;
        return null;
    }
}

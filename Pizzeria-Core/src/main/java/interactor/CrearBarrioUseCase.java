package interactor;

import excepciones.BarrioExisteException;
import input.ICrearBarrioInput;
import modelo.Barrio;
import repositorio.IRespositorioCrearBarrio;

public class CrearBarrioUseCase implements ICrearBarrioInput {

    private IRespositorioCrearBarrio crearBarrioGateway;

    public CrearBarrioUseCase(IRespositorioCrearBarrio crearBarrioGateway) {
        this.crearBarrioGateway = crearBarrioGateway;
    }

    @Override
    public boolean crearBarrio(Barrio elBarrio) throws BarrioExisteException {
        if(existeBarrio(elBarrio)){
            throw new BarrioExisteException();
        }
        return this.crearBarrioGateway.guardar(elBarrio);
    }

    public boolean existeBarrio(Barrio elBarrio){
        return crearBarrioGateway.buscarBarrioPorNombre(elBarrio.getNombre()) != null;
    }
}

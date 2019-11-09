package interactor;

import excepciones.BarrioExisteException;
import modelo.Barrio;
import repositorio.IRespositorioCrearBarrio;

public class CrearBarrioUseCase {

    private IRespositorioCrearBarrio crearBarrioGateway;

    public CrearBarrioUseCase(IRespositorioCrearBarrio crearBarrioGateway) {
        this.crearBarrioGateway = crearBarrioGateway;
    }

    public boolean existeBarrio(Barrio elBarrio){
        return crearBarrioGateway.buscarBarrioPorNombre(elBarrio.getNombre()) != null;
    }

    public boolean crearBarrio(Barrio elBarrio) throws BarrioExisteException {
        if(!existeBarrio(elBarrio)){
            return this.crearBarrioGateway.guardar(elBarrio);
        }
        throw new BarrioExisteException();
    }
}

<<<<<<< HEAD
package interactorUnitTest;


import Mockito.MockitoExtension;
import excepciones.BarrioExisteException;
import excepciones.BarrioIncompletoException;
import interactor.CrearBarrioUseCase;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRespositorioCrearBarrio;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearBarrioUnitTest {

    @Mock
    IRespositorioCrearBarrio CrearBarrioGateWay;

    @Test
    public void CrearBarrio_BarrioNoExiste_GuardadoCorrecto() throws BarrioIncompletoException, BarrioExisteException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        when(CrearBarrioGateWay.guardar(elBarrio)).thenReturn(true);
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(CrearBarrioGateWay);
        boolean resultado = crearBarrioUseCase.crearBarrio(elBarrio);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void CrearBarrio_BarrioExiste_BarrioExisteException() throws BarrioIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        when(CrearBarrioGateWay.buscarBarrioPorNombre("Centro")).thenReturn(Barrio.factoryBarrio(2, "Centro"));
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(CrearBarrioGateWay);
        Assertions.assertThrows(BarrioExisteException.class, ()-> crearBarrioUseCase.crearBarrio(elBarrio));
    }

}
=======
package interactorUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class CrearBarrioUnitTest {
    @Mock
    IRepositorioCrearBarrio crearBarrioGatway;

    @Test
    public void crearBarrio_BarrioNoExiste_GuardaCorrectamente() throws BarrioIncompletoException, BarrioIncompletoException, BarrioExisteException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        when(crearBarrioGatway.guardar(elBarrio)).thenReturn(true);
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(crearBarrioGatway);
        boolean resultado = crearBarrioUseCase.CrearBarrio(elBarrio);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearBarrio_BarrioExiste_BarrioExisteException() throws BarrioIncompletoException, BarrioIncompletoException {
        Barrio elBarrio = Barrio.factoryBarrio(1, "Centro");
        when(crearBarrioGatway.buscarBarrioPorNombre("Centro")).thenReturn(Barrio.factoryBarrio(2, "Centro"));
        CrearBarrioUseCase crearBarrioUseCase = new CrearBarrioUseCase(crearBarrioGatway);
        Assertions.assertThrows(BarrioExisteException.class, () -> crearBarrioUseCase.CrearBarrio(elBarrio));
    }
}
>>>>>>> master

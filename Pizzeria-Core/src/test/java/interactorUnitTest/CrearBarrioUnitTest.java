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

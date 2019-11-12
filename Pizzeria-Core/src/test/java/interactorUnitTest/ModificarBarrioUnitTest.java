package interactorUnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import excepciones.BarrioIncompletoException;
import modelo.Barrio;

public class ModificarBarrioUnitTest {
	 @Test
     void modificarBarrio_CambiarNombre_ModificacionCorrecta() throws BarrioIncompletoException {
         Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
         elBarrio.setNombre("Independencia");
         assertEquals("Independencia" , elBarrio.getNombre());
     }

}

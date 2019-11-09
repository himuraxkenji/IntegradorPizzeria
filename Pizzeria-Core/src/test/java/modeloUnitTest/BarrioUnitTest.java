package modeloUnitTest;

import excepciones.BarrioIncompletoException;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarrioUnitTest {
      @Test
        void instanciarBarrioBarrioCompletoInstanciaCorrecta() throws BarrioIncompletoException {
            Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
            assertNotNull(elBarrio);
        }

        @Test
        void instanciarBarrioBarrioSinNombreBarrioInstanciaIncorrecta() {
            Assertions.assertThrows(BarrioIncompletoException.class, ()-> Barrio.factoryBarrio(1,"Centro") );
        }
    
    
    
}

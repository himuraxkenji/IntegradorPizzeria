package modeloUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BarrioUnitTest {
      @Test
        void instanciarBarrioBarrioCompletoInstanciaCorrecta() {
            Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
            assertNotNull(elBarrio);
        }

        @Test
        void instanciarBarrioBarrioSinNombreBarrioInstanciaIncorrecta() {
            Assertions.assertThrows(BarrioSinNombreException.class, ()-> Barrio.factoryBarrio(1,"Centro") );
        }
    
    
    
}

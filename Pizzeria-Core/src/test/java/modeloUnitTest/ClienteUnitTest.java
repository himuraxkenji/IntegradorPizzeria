package modeloUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ClienteUnitTest {
    @Test
    void instanciarClienteClienteCompletoInstanciaCorrecta() {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio.getNombre(),"39400500");
        assertNotNull(elCliente);
    }

    @Test
    void instanciarClienteClienteSinDocumentoClienteInstanciaIncorrecta() {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Assertions.assertThrows(ClienteSinDocumentoException.class, ()-> Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio.getNombre(),"39400500") );
    }


    }
    
}

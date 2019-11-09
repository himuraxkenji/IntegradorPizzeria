package modeloUnitTest;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ClienteUnitTest {
    @Test
    void instanciarClienteClienteCompletoInstanciaCorrecta() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Cliente elCliente= Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"39400500");
        assertNotNull(elCliente);
    }

    @Test
    void instanciarClienteClienteSinDocumentoClienteInstanciaIncorrecta() throws BarrioIncompletoException {
        Barrio elBarrio=Barrio.factoryBarrio(1,"Centro");
        Assertions.assertThrows(ClienteIncompletoException.class, ()-> Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43",elBarrio,"") );
    }


}
    


package modeloUnitTest;

import org.junit.jupiter.api.Test;

public class ClienteUnitTest {
    @Test
    void instanciarClienteClienteCompletoInstanciaCorrecta() {
        Cliente elCliente=Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43","Centro","39400500");
        assertNotNull(elCliente);
    }

    @Test
    void instanciarClienteClienteSinDocumentoClienteInstanciaIncorrecta() {
        Assertions.assertThrows(ClienteSinDocumentoException.class, ()-> Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43","Centro","39400500") );
    }
    
}

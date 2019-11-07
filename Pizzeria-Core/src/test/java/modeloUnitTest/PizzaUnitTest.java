package modeloUnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PizzaUnitTest {
    @Test
    void instanciarPizzaPizzaCompletoInstanciaCorrecta() {
        Pizza laPizza=Pizza.factoryPizza(1,"Napolitana",250.00,15);
        assertNotNull(laPizza);
    }

    @Test
    void instanciarPizzaPizzaSinNombrePizzaInstanciaIncorrecta() {
        Assertions.assertThrows(PizzaSinNombreException.class, ()-> Pizza.factoryPizza(1,"Napolitana",250.00,15) );
    }



}

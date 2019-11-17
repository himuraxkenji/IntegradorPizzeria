package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.CrearClienteRepoImpl;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearClienteIT {

    @Autowired
    CrearClienteRepoImpl crearClienteRepoImpl;

    @Test
    public void crearCliente_clienteNoExistente_creadoCorrectamente() throws BarrioIncompletoException, ClienteIncompletoException {

        Barrio miBarrio = Barrio.factoryBarrio(1, "Castro y Bazan");
        Cliente cliente = Cliente.factoryCliente(1, "Jose Soria", "Castro y Bazan", miBarrio, "39300672");
        boolean respuesta = crearClienteRepoImpl.(cliente);

        assertTrue(respuesta);

    }


}

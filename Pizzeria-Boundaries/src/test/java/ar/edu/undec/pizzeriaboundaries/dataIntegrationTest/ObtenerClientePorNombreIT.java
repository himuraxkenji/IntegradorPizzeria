/*package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerClientePorNombreRepoImpl;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerClientePorNombreIT {

    @Autowired
    private ObtenerClientePorNombreRepoImpl obtenerClientePorNombreRepo;


    @Test
    public void obtenerClientePorNombre_clienteDevuelto_clienteCorrecto() throws BarrioIncompletoException, ClienteIncompletoException {

        List<Cliente> misClientes = obtenerClientePorNombreRepo.obtenerClientePorNombre("Jose");

        assertEquals(1, misClientes.size());

    }



}
*/
/*package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import input.IObtenerClientePorNombreInput;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerClientePorNombreIT {

    @Mock
    IObtenerClientePorNombreInput iObtenerClientePorNombreInput;

    @Test
    public void obtenerCliente_nombreCliente_clienteCorrecto(){

        ClienteDTO obtenerCliente = new ClienteDTO(1, "Jose", "Castro y Bazan", "39300672", new BarrioDTO(1, "Castro y Bazan"));
        when(iObtenerClientePorNombreInput.obtenerClientePorNombre("Jose").thenReturn());

    }


}
*/
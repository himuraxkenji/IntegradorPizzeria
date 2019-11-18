package ar.edu.undec.pizzeriaboundaries.controllerIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.BarrioDTO;
import ar.edu.undec.pizzeriaboundaries.Service.ModeloService.ClienteDTO;
import input.ICrearClienteInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearClienteServiceIT {

    @Mock
    ICrearClienteInput iCrearClienteInput;

    @Test
    public void crearCliente_clienteCreado_devuelveTrue(){

        BarrioDTO nuevoBarrio = new BarrioDTO(1, "Castro y Bazan");
        ClienteDTO nuevoCliente = new ClienteDTO(1, "Jose Soria", "Castro y Bazan", "39300672", nuevoBarrio);
        CrearClienteController crearClienteController = new CrearClienteController(iCrearClienteInput);
        assertEquals(crearClienteController.crearClienteController(nuevoCliente).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);

    }






}

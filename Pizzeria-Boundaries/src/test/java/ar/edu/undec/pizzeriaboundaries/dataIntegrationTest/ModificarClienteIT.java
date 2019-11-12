package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ActualizarClienteRepoImpl;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ModificarClienteIT {
    @Autowired
    ActualizarClienteRepoImpl actualizarClienteRepo;

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarClienteAntesUno.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarClienteDespues.sql")
    })
    public void actualizarCliente_ClienteGuardado_devuelveTrue() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(1, "80 Lotes");
        Cliente cliente= Cliente.factoryCliente(1, "Santiago","San Roman", barrio,"43.226.263");
        boolean resultado= actualizarClienteRepo.actualizar(cliente);
        assertTrue(resultado);
    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarClienteAntesDos.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarClienteDespues.sql")
    })
    public void actualizarCliente_ClienteConOtroId_devuelveFalse() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(1, "80 Lotes");
        Cliente clienteDatosNuevos= Cliente.factoryCliente(1, "Renegado","San Roman", barrio,"43.226.263");
        actualizarClienteRepo.actualizar(clienteDatosNuevos);
        boolean resultado= actualizarClienteRepo.actualizar(clienteDatosNuevos);
        assertFalse(resultado);
    }

}

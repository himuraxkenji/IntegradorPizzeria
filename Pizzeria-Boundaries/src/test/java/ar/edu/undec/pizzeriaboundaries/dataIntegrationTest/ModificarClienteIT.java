package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;


import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ActualizarClienteRepoImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:modificarCliente/actualizarClienteAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:modificarCliente/actualizarClienteDespues.sql")
})
public class ModificarClienteIT {
    @Autowired
    ActualizarClienteRepoImpl actualizarClienteRepo;

    @Test
    public void actualizarCliente_ClienteGuardado_devuelveTrue() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(1, "80 Lotes");
        Cliente cliente= Cliente.factoryCliente(1, "Santiago","San Roman", barrio,"43.226.263");
        boolean resultado= actualizarClienteRepo.actualizar(cliente);
        assertTrue(resultado);
    }

    @Test
    public void actualizarCliente_ClienteConOtroId_devuelveFalse() throws BarrioIncompletoException, ClienteIncompletoException {
        Barrio barrio = Barrio.factoryBarrio(1, "80 Lotes");
        Cliente clienteUno= Cliente.factoryCliente(1, "Renegado","San Roman", barrio,"43.226.263");
        Cliente clienteDos= Cliente.factoryCliente(2, "Santiago","San Roman", barrio,"43.226.263");
        actualizarClienteRepo.actualizar(clienteUno);
        boolean resultado= actualizarClienteRepo.actualizar(clienteDos);
        assertFalse(resultado);
    }

}

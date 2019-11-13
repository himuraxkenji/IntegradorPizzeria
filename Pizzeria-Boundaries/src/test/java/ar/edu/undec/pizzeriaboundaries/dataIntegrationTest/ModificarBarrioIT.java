package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ActualizarBarrioRepoImpl;
import excepciones.BarrioIncompletoException;
import modelo.Barrio;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.Assert.assertTrue;

public class ModificarBarrioIT {
    @Autowired
    ActualizarBarrioRepoImpl actualizarBarrioRepo;

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:actualizarBarrioAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:actualizarBarrioDespues.sql")
    })
    @Test
    public void actualizarBarrio_BarrioGuardado_devuelveTrue() throws BarrioIncompletoException{
        Barrio barrio = Barrio.factoryBarrio(1, "Altos de Chilecito");

        boolean resultado= actualizarBarrioRepo.actualizar(barrio);
        assertTrue(resultado);
    }

}

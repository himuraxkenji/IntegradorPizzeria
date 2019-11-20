/*package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import ar.edu.undec.pizzeriaboundaries.Data.RepositorioImplementacion.ObtenerPizzasMasVendidasEntreFechasRepoImpl;
import excepciones.FechaIncorrectaException;
import excepciones.PedidoIncompletoException;
import excepciones.PizzaIncompletaException;
import static org.testng.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerPizzasMasVendidasEntreFechasIT {

    @Autowired
    private ObtenerPizzasMasVendidasEntreFechasRepoImpl obtenerPizzasMasVendidasEntreFechasRepo;

    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerPizzasMasVendidasEntreFechasAntes.sql"),
             })




    @Test
    public void obtenerPizzasMasVendidasEntreFechas_DevuelveListaCorrecta() throws PedidoIncompletoException, PizzaIncompletaException, FechaIncorrectaException {
        LocalDateTime fechaInicio = LocalDateTime.of(2019,11, 7, 20, 15);
        LocalDateTime fechaFin = LocalDateTime.of(2019, 11, 10, 21, 14);
        ArrayList<String> resultado = obtenerPizzasMasVendidasEntreFechasRepo.obtenerPizzasMasVendidasEntreFechas(fechaInicio, fechaFin);






        assertEquals(resultado.get(0),"Napolitana 4" );
        assertEquals(resultado.get(1),"Comun 4" );
    }


}
*/
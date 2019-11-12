package ar.edu.undec.pizzeriaboundaries.dataIntegrationTest;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

@SpringBootTest
public class ObtenerClientePorNombreIT {

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:obtenerClientePorNombreAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:obtenerClientePorNombreDespues.sql")})

    public void obtenerClientePorNombre_clienteDevuelto_clienteCorrecto() throws BarrioIncompletoException, ClienteIncompletoException {


        Barrio elBarrio = Barrio.factoryBarrio(1,"Castro Y Bazan");
        Barrio elBarrio2 = Barrio.factoryBarrio(2,"Paiman");
        Barrio elBarrio3 = Barrio.factoryBarrio(3,"Poman");


        Cliente elCliente = Cliente.factoryCliente(1,"Jose","Castro y Bazan", elBarrio,"39300672");
        Cliente elCliente2 = Cliente.factoryCliente(1,"Juan","9 de julio", elBarrio2,"39300672");
        Cliente elCliente3 = Cliente.factoryCliente(1,"Pepito","CualquierCalle", elBarrio3,"39300672");




    }



}

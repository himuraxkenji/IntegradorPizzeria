package interactorUnitTest;

import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import interactor.ObtenerClientePorNombreUseCase;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class ObtenerClientePorNombreUnitTest {

    @Mock
    IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    @Spy
    ArrayList<Cliente> misClientes = factoryListaClientes();

    public ObtenerClientePorNombreUnitTest() throws ClienteIncompletoException, BarrioIncompletoException {
    }

    @Test
    public void obtenerCLientePorNombre_listaClientes_clienteCorrecto(){

        //REVISAR, NO FUNCIONA
        when(iRepositorioObtenerClientePorNombre.obtenerClientePorNombre("Jose")).thenReturn(misClientes);
        ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase = new ObtenerClientePorNombreUseCase(iRepositorioObtenerClientePorNombre);
        ArrayList<Cliente> lista = obtenerClientePorNombreUseCase.obtenerPilotoPorNombre("Jose");

        Assertions.assertEquals(1, lista.size());
    }

    private ArrayList<Cliente> factoryListaClientes() throws ClienteIncompletoException, BarrioIncompletoException {

        ArrayList misClientes = new ArrayList();

        Barrio elBarrio1 = Barrio.factoryBarrio(1,"Centro");
        Barrio elBarrio2 = Barrio.factoryBarrio(1,"Poman");
        Barrio elBarrio3 = Barrio.factoryBarrio(1,"Paiman");
        Barrio elBarrio4 = Barrio.factoryBarrio(1,"Castro Y Bazan");

        Cliente elCliente1 = Cliente.factoryCliente(1,"Juan Asis","Timoteo Gordillo 43", elBarrio1,"39400500");
        Cliente elCliente2 = Cliente.factoryCliente(1,"Rodrigo Alarcon","Cualquier Calle", elBarrio2,"37321123");
        Cliente elCliente3 = Cliente.factoryCliente(1,"Daniel Paez","Brasil 12", elBarrio3,"38123321");
        Cliente elCliente4 = Cliente.factoryCliente(1,"Jose Soria","Castro Y Bazan", elBarrio4,"39300672");

        misClientes.add(elCliente1);
        misClientes.add(elCliente2);
        misClientes.add(elCliente3);
        misClientes.add(elCliente4);

        return misClientes;
    }


}

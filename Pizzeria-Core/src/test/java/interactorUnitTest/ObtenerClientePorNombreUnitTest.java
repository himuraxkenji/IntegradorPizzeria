package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.BarrioIncompletoException;
import excepciones.ClienteIncompletoException;
import interactor.ObtenerClientePorNombreUseCase;
import modelo.Barrio;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IRepositorioObtenerClientePorNombre;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerClientePorNombreUnitTest {


    @Mock
    IRepositorioObtenerClientePorNombre iRepositorioObtenerClientePorNombre;

    @Spy
    List<Cliente> misClientes = factoryListaClientes();


    public ObtenerClientePorNombreUnitTest() throws ClienteIncompletoException, BarrioIncompletoException {
    }

    @Test
    public void obtenerCLientePorNombre_listaClientes_devuelveListaCorrecto(){

        //REVISAR, NO FUNCIONA
        when(iRepositorioObtenerClientePorNombre.obtenerClientePorNombre("Jose")).thenReturn(misClientes);
        ObtenerClientePorNombreUseCase obtenerClientePorNombreUseCase = new ObtenerClientePorNombreUseCase(iRepositorioObtenerClientePorNombre);
        List<Cliente> lista = obtenerClientePorNombreUseCase.obtenerClientePorNombre("Jose");


        Assertions.assertEquals(1, lista.size());

    }

    public List<Cliente> factoryListaClientes() throws ClienteIncompletoException, BarrioIncompletoException {

        List<Cliente> misClientes = new ArrayList();

        Barrio elBarrio1 = Barrio.factoryBarrio(1,"Centro");
        Barrio elBarrio2 = Barrio.factoryBarrio(1,"Poman");
        Barrio elBarrio3 = Barrio.factoryBarrio(1,"Paiman");
        Barrio elBarrio4 = Barrio.factoryBarrio(1,"Castro Y Bazan");

        Cliente elCliente1 = Cliente.factoryCliente(1,"Juan","Timoteo Gordillo 43", elBarrio1,"39400500");
        Cliente elCliente2 = Cliente.factoryCliente(1,"Rodrigo","Cualquier Calle", elBarrio2,"37321123");
        Cliente elCliente3 = Cliente.factoryCliente(1,"Daniel","Brasil 12", elBarrio3,"38123321");
        Cliente elCliente4 = Cliente.factoryCliente(1,"Jose","Castro Y Bazan", elBarrio4,"39300672");

        misClientes.add(elCliente1);
        misClientes.add(elCliente2);
        misClientes.add(elCliente3);
        misClientes.add(elCliente4);

        return misClientes;
    }


}

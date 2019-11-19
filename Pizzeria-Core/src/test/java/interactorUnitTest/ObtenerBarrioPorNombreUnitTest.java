package interactorUnitTest;

import Mockito.MockitoExtension;
import modelo.Barrio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerBarrioPorNombreUnitTest {

    @Mock
    IBuscarBarrioPorNombre buscarBarrioPorNombre;

    @Spy
    List<Barrio> barriosList = factoryListaBarrios();

    @Test
    public void buscarBarrioPorNombre_ExisteBarrio_devuelveBarrio(){
        when(buscarBarrioPorNombre.buscarBarrioPorNombre("140 Lotes")).thenReturn(barriosList);
        BuscarBarrioPorNombreUseCase buscarBarrio = new BuscarBarrioPorNombreUseCase(buscarBarrioPorNombre);
        List<Barrio> resultado = buscarBarrio.buscarBarrioPorNombre("140 Lotes");
        Assertions.assertEquals(1,resultado.size());

    }

    private List<Barrio> factoryListaBarrios() {
        try {
            List<Barrio> barrios = new ArrayList<Barrio>();
            Barrio barrio= factoryBarrio(1, "140 Lotes");
            barrios.add(barrio);
            return barrios;
        } catch (BarrioIncompletoException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}

package repositorio;



import modelo.Pizza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public interface IRepositorioObtenerPizzasMasVendidasEntreFechas {

    public LinkedHashMap<Integer, ArrayList<Pizza>> obtenerPizzasMasVendidasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);


}
